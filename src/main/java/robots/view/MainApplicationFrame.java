package robots.view;

import robots.model.helpz.profileManager;
import robots.model.i18n.I18nProvider;
import robots.model.log.Logger;
import robots.view.Menu.CustomJmenuBar;
import robots.view.ui.ProfileSaveWindow;
import robots.view.ui.ProfileWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

public class MainApplicationFrame extends JFrame {

    private final JDesktopPane desktopPane = new JDesktopPane();
    private final GameWindow gameWindow = createGameWindow();
    private final LogWindow logWindow = createLogWindow();
    private final ProfileWindow profileWindow = createProfileWindow();

    private CustomJmenuBar customJmenuBar = new CustomJmenuBar(this);

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

        addWindow(profileWindow);

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
                    ProfileSaveWindow a = createProfileSaveWindow();
                    a.setVisible(true);
                }
            }
        });
    }

    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setLocation(profileManager.getLogWindowPos());
        logWindow.setSize(300, 800);
        setMinimumSize(logWindow.getSize());
        logWindow.pack();
        Logger.debug(I18nProvider.getLogWindowMessage("log_default_msg"));
        Logger.debug(I18nProvider.getLogWindowMessage("curr_locale_is_msg") + String.valueOf(Locale.getDefault()));
        return logWindow;
    }

    protected GameWindow createGameWindow() {
        GameWindow gameWindow = new GameWindow();
        gameWindow.setLocation(profileManager.getGameWindowPos());
        gameWindow.setSize(640, 800);
        return gameWindow;
    }

    protected ProfileWindow createProfileWindow() {
        ProfileWindow profileWindow = new ProfileWindow(this);
        profileWindow.setLocation(new Point(500, 100));
        profileWindow.setSize(500, 100);
        return profileWindow;
    }

    public ProfileSaveWindow createProfileSaveWindow() {
        ProfileSaveWindow ProfileSaveWindow = new ProfileSaveWindow(this);
        ProfileSaveWindow.setLocation(500, 100);
        ProfileSaveWindow.setSize(500, 300);
        return ProfileSaveWindow;
    }

    public void addWindow(JInternalFrame frame) {
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

    public void globalClose() {
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
        return gameWindow.getLocation();
    }
    public Point getLogWindowPos() {
        return logWindow.getLocation();
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public LogWindow getLogWindow() {
        return logWindow;
    }

    public CustomJmenuBar getCustomJmenuBar() {
        return customJmenuBar;
    }
    public JDesktopPane getDesktopPane(){
        return desktopPane;
    }
}
