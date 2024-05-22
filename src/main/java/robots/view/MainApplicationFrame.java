package robots.view;

import robots.model.helpz.profileManager;
import robots.model.i18n.I18nProvider;
import robots.model.log.Logger;
import robots.view.Menu.CustomJmenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

public class MainApplicationFrame extends JFrame {

    private final JDesktopPane desktopPane = new JDesktopPane();
    private final GameWindow gameWindow = createGameWindow();
    private final LogWindow logWindow = createLogWindow();

    public MainApplicationFrame() {
        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(
                inset,
                inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        setContentPane(desktopPane);

        addWindow(logWindow);
        addWindow(gameWindow);

        CustomJmenuBar customJmenuBar = new CustomJmenuBar(this);
        setJMenuBar(customJmenuBar.generateMenuBar());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {
                        I18nProvider.getDataMessage("yes"),
                        I18nProvider.getDataMessage("no")
                };

                int result = JOptionPane.showOptionDialog(
                        null,
                        I18nProvider.getDataMessage("close"),
                        I18nProvider.getDataMessage("confirm"),
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[0]
                );
                if (result == JOptionPane.YES_OPTION) {
                    profileManager.setGameWindowPos(getGameWindowPos());
                    profileManager.setLogWindowPos(logWindow.getLocationOnScreen());
                    profileManager.WriteToFile();
                    globalClose();
                    dispose();
                    System.exit(0);
                }
            }
        });
    }

    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setLocation(10, 10);
        logWindow.setSize(300, 800);
        setMinimumSize(logWindow.getSize());
        logWindow.pack();
        Logger.debug(I18nProvider.getLogWindowMessage("log_default_msg"));
        Logger.debug(I18nProvider.getLogWindowMessage("curr_locale_is_msg") + String.valueOf(Locale.getDefault()));
        return logWindow;
    }

    protected GameWindow createGameWindow() {
        GameWindow gameWindow = new GameWindow();
        gameWindow.setSize(640, 800);
        return gameWindow;
    }

    protected void addWindow(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    public void updateUiFrames() {
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof AbstractWindow) {
                ((AbstractWindow) frame).onUiChanged();
            }
        }

    }

    private void globalClose() {
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof AbstractWindow) {
                frame.dispose();
            }
        }
    }

    public void updateDesktopPane() {
        for (JInternalFrame frame : desktopPane.getAllFrames()) {
            if (frame instanceof AbstractWindow) {
                ((AbstractWindow) frame).onUiChanged();
            }
        }
        updateMainFrame();
    }
    public void updateMainFrame() {
        CustomJmenuBar customJmenuBar = new CustomJmenuBar(this);
        setJMenuBar(customJmenuBar.generateMenuBar());
        desktopPane.revalidate();
        desktopPane.repaint();
    }

    public Point getGameWindowPos() {
        return gameWindow.getLocationOnScreen();
    }
    public Point getLogWindowPos() {
        return logWindow.getLocationOnScreen();
    }
}
