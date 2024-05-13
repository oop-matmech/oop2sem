package robots.view;

import robots.model.i18n.I18nBundles;
import robots.model.i18n.I18nProvider;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public abstract class AbstractWindow extends JInternalFrame implements UiChangedListener {

    public AbstractWindow(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                Object[] options = {
                        I18nProvider.getDataMessage("yes"),
                        I18nProvider.getDataMessage("no"),
                };

                int result = JOptionPane.showOptionDialog(
                        AbstractWindow.this,
                        I18nProvider.getDataMessage("close"),
                        I18nProvider.getDataMessage("confirm"),
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[0]
                );
                if (result == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
    }

    public abstract void onUiChanged();

    @Override
    public void dispose() {
        closeWindow();
        super.dispose();
    }

    protected abstract void closeWindow();
}
