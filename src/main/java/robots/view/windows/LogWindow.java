package robots.view.windows;

import robots.model.i18n.I18nBundles;
import robots.model.i18n.I18nProvider;
import robots.model.log.LogChangeListener;
import robots.model.log.LogEntry;
import robots.model.log.LogWindowSource;
import robots.view.AbstractWindow;

import javax.swing.*;
import java.awt.*;


public class LogWindow extends AbstractWindow implements LogChangeListener {
    private LogWindowSource m_logSource;
    private TextArea m_logContent;

    public LogWindow(LogWindowSource logSource) {
        super(I18nProvider.getMessage(I18nBundles.LOG_WINDOW, "log_window_name"), true, true, true, true);
        m_logSource = logSource;
        m_logSource.registerListener(this);
        m_logContent = new TextArea("");
        m_logContent.setSize(200, 500);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_logContent, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
        updateLogContent();
    }

    @Override
    public void doDefaultCloseAction() {
        m_logSource.unregisterListener(this);
        super.doDefaultCloseAction();
    }

    private void updateLogContent() {
        StringBuilder content = new StringBuilder();
        for (LogEntry entry : m_logSource.all()) {
            content.append(entry.getMessage()).append("\n");
        }
        m_logContent.setText(content.toString());
        m_logContent.invalidate();
    }

    @Override
    public void onLogChanged() {
        EventQueue.invokeLater(this::updateLogContent);
    }

    public void onUiChanged() {
        setTitle(I18nProvider.getMessage(I18nBundles.LOG_WINDOW, "log_window_name"));
        revalidate();
        repaint();
    }

    @Override
    protected void closeWindow() {
        m_logSource.unregisterListener(this);
    }
}
