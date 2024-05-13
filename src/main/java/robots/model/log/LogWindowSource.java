package robots.model.log;

import java.util.Collections;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Что починить:
 * -------- сделано -------
 * 1. Этот класс порождает утечку ресурсов (связанные слушатели оказываются
 * удерживаемыми в памяти)
 * ------ сделано -------
 * 2. Этот класс хранит активные сообщения лога, но в такой реализации он
 * их лишь накапливает. Надо же, чтобы количество сообщений в логе было ограничено
 * величиной m_iQueueLength (т.е. реально нужна очередь сообщений
 * ограниченного размера)
 */
public class LogWindowSource {
    private int m_iQueueLength;
    AtomicInteger mCounter = new AtomicInteger(0);
    private BlockingDeque<LogEntry> m_messages;
    private final ConcurrentLinkedDeque<LogChangeListener> m_listeners;
    private volatile LogChangeListener[] m_activeListeners;

    public LogWindowSource(int iQueueLength) {
        m_iQueueLength = iQueueLength;
        m_messages = new LinkedBlockingDeque<>(iQueueLength);
        m_listeners = new ConcurrentLinkedDeque<LogChangeListener>();
    }

    public void registerListener(LogChangeListener listener) {
        if (!m_listeners.contains(listener)) {
            m_listeners.offer(listener);
        }
        m_activeListeners = null;
    }

    public void unregisterListener(LogChangeListener listener) {
        m_listeners.remove(listener);
        m_activeListeners = null;
    }

    public void append(LogLevel logLevel, String strMessage) {
        LogEntry entry = new LogEntry(logLevel, strMessage);

        boolean status = false;
        do {
            if (mCounter.getAndIncrement() >= m_iQueueLength) {
                m_messages.pollFirst();
                mCounter.getAndDecrement();
            }
            status = m_messages.offerLast(entry);
        } while (!status);
        triggerLogs();
    }

    public synchronized void triggerLogs() {
        LogChangeListener[] activeListeners = m_activeListeners;
        if (activeListeners == null) {
            updateActiveListeners();
            activeListeners = m_activeListeners;
        }
        for (LogChangeListener listener : activeListeners) {
            listener.onLogChanged();
        }
    }

    public synchronized void updateActiveListeners() {
        m_activeListeners = m_listeners.toArray(new LogChangeListener[0]);
    }

    public int size() {
        return m_messages.size();
    }

    public Iterable<LogEntry> range(int startFrom, int count) {
        if (startFrom < 0 || startFrom >= size()) {
            return Collections.emptyList();
        }
        int indexTo = Math.min(startFrom + count, size());
        return m_messages.stream().toList().subList(startFrom, indexTo);
    }

    public Iterable<LogEntry> all() {
        return m_messages;
    }
}
