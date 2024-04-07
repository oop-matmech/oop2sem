package robots.model.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LogWindowSourceDiffblueTest {
    /**
     * Method under test:
     * {@link LogWindowSource#registerListener(LogChangeListener)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterListener() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.linkLast(ConcurrentLinkedDeque.java:347)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.offerLast(ConcurrentLinkedDeque.java:865)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.offer(ConcurrentLinkedDeque.java:979)
        //       at robots.model.log.LogWindowSource.registerListener(LogWindowSource.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        Logger.getDefaultLogSource().registerListener(null);
    }

    /**
     * Method under test:
     * {@link LogWindowSource#registerListener(LogChangeListener)}
     */
    @Test
    void testRegisterListener2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        Logger.getDefaultLogSource().registerListener(mock(LogChangeListener.class));
    }

    /**
     * Method under test:
     * {@link LogWindowSource#unregisterListener(LogChangeListener)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnregisterListener() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.removeFirstOccurrence(ConcurrentLinkedDeque.java:1030)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.remove(ConcurrentLinkedDeque.java:1142)
        //       at robots.model.log.LogWindowSource.unregisterListener(LogWindowSource.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        Logger.getDefaultLogSource().unregisterListener(null);
    }

    /**
     * Method under test:
     * {@link LogWindowSource#unregisterListener(LogChangeListener)}
     */
    @Test
    void testUnregisterListener2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        Logger.getDefaultLogSource().unregisterListener(mock(LogChangeListener.class));
    }

    /**
     * Method under test: {@link LogWindowSource#append(LogLevel, String)}
     */
    @Test
    void testAppend() {
        // Arrange
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();

        // Act
        defaultLogSource.append(LogLevel.Trace, "Str Message");

        // Assert
        assertEquals(5, ((Collection<LogEntry>) defaultLogSource.all()).size());
        assertEquals(5, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#append(LogLevel, String)}
     */
    @Test
    void testAppend2() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.append(LogLevel.Trace, "foo");

        // Assert
        verify(listener).onLogChanged();
        assertEquals(5, ((Collection<LogEntry>) defaultLogSource.all()).size());
        assertEquals(5, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#append(LogLevel, String)}
     */
    @Test
    void testAppend3() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();

        LogWindowSource logWindowSource = new LogWindowSource(3);
        logWindowSource.registerListener(listener);

        // Act
        logWindowSource.append(LogLevel.Trace, "foo");

        // Assert
        verify(listener).onLogChanged();
        assertEquals(1, ((Collection<LogEntry>) logWindowSource.all()).size());
        assertEquals(1, logWindowSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#append(LogLevel, String)}
     */
    @Test
    void testAppend4() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.append(LogLevel.Debug, "foo");

        // Assert
        verify(listener).onLogChanged();
        assertEquals(5, ((Collection<LogEntry>) defaultLogSource.all()).size());
        assertEquals(5, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#append(LogLevel, String)}
     */
    @Test
    void testAppend5() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.append(LogLevel.Info, "foo");

        // Assert
        verify(listener).onLogChanged();
        assertEquals(5, ((Collection<LogEntry>) defaultLogSource.all()).size());
        assertEquals(5, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#append(LogLevel, String)}
     */
    @Test
    void testAppend6() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.append(LogLevel.Warning, "foo");

        // Assert
        verify(listener).onLogChanged();
        assertEquals(5, ((Collection<LogEntry>) defaultLogSource.all()).size());
        assertEquals(5, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#append(LogLevel, String)}
     */
    @Test
    void testAppend7() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.append(LogLevel.Error, "foo");

        // Assert
        verify(listener).onLogChanged();
        assertEquals(5, ((Collection<LogEntry>) defaultLogSource.all()).size());
        assertEquals(5, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#append(LogLevel, String)}
     */
    @Test
    void testAppend8() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.append(LogLevel.Fatal, "foo");

        // Assert
        verify(listener).onLogChanged();
        assertEquals(5, ((Collection<LogEntry>) defaultLogSource.all()).size());
        assertEquals(5, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs2() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(listener);
        defaultLogSource.append(LogLevel.Debug, null);

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener, atLeast(1)).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs3() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.unregisterListener(mock(LogChangeListener.class));
        defaultLogSource.registerListener(listener);
        defaultLogSource.append(LogLevel.Debug, "Str Message");

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener, atLeast(1)).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs4() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.unregisterListener(mock(LogChangeListener.class));
        defaultLogSource.registerListener(listener);
        defaultLogSource.append(LogLevel.Debug, "robots.model.log.LogChangeListener[]");

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener, atLeast(1)).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#size()}
     */
    @Test
    void testSize() {
        // Arrange, Act and Assert
        assertEquals(5, Logger.getDefaultLogSource().size());
    }

    /**
     * Method under test: {@link LogWindowSource#size()}
     */
    @Test
    void testSize2() {
        // Arrange
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.append(LogLevel.Warning, "Str Message");

        // Act and Assert
        assertEquals(5, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#size()}
     */
    @Test
    void testSize3() {
        // Arrange
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(mock(LogChangeListener.class));

        // Act and Assert
        assertEquals(5, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#range(int, int)}
     */
    @Test
    void testRange() {
        // Arrange and Act
        Iterable<LogEntry> actualRangeResult = Logger.getDefaultLogSource().range(1, 3);
        actualRangeResult.iterator();

        // Assert
        assertEquals(3, ((List<LogEntry>) actualRangeResult).size());
    }

    /**
     * Method under test: {@link LogWindowSource#range(int, int)}
     */
    @Test
    void testRange2() {
        // Arrange and Act
        Iterable<LogEntry> actualRangeResult = Logger.getDefaultLogSource().range(0, 1);
        actualRangeResult.iterator();

        // Assert
        assertEquals(1, ((List<LogEntry>) actualRangeResult).size());
    }

    /**
     * Method under test: {@link LogWindowSource#range(int, int)}
     */
    @Test
    void testRange3() {
        // Arrange and Act
        Iterable<LogEntry> actualRangeResult = Logger.getDefaultLogSource().range(-1, 1);
        actualRangeResult.iterator();

        // Assert
        assertTrue(((List<LogEntry>) actualRangeResult).isEmpty());
    }

    /**
     * Method under test: {@link LogWindowSource#range(int, int)}
     */
    @Test
    void testRange4() {
        // Arrange
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(mock(LogChangeListener.class));

        // Act
        Iterable<LogEntry> actualRangeResult = defaultLogSource.range(1, 3);
        actualRangeResult.iterator();

        // Assert
        assertEquals(3, ((List<LogEntry>) actualRangeResult).size());
    }

    /**
     * Method under test: {@link LogWindowSource#all()}
     */
    @Test
    void testAll() {
        // Arrange and Act
        Iterable<LogEntry> actualAllResult = Logger.getDefaultLogSource().all();
        actualAllResult.iterator();

        // Assert
        assertEquals(5, ((Collection<LogEntry>) actualAllResult).size());
    }

    /**
     * Method under test: {@link LogWindowSource#all()}
     */
    @Test
    void testAll2() {
        // Arrange
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(mock(LogChangeListener.class));

        // Act
        Iterable<LogEntry> actualAllResult = defaultLogSource.all();
        actualAllResult.iterator();

        // Assert
        assertEquals(5, ((Collection<LogEntry>) actualAllResult).size());
    }

    /**
     * Method under test: {@link LogWindowSource#LogWindowSource(int)}
     */
    @Test
    void testNewLogWindowSource() {
        // Arrange and Act
        LogWindowSource actualLogWindowSource = new LogWindowSource(3);

        // Assert
        assertEquals(0, actualLogWindowSource.mCounter.get());
        assertTrue(((Collection<LogEntry>) actualLogWindowSource.all()).isEmpty());
    }
}
