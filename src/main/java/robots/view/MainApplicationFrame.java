package robots.view;

import robots.model.i18n.I18nBundles;
import robots.model.i18n.I18nProvider;
import robots.model.log.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * ------- сделано ---------
 * Что требуется сделать:
 * 1. Метод создания меню перегружен функционалом и трудно читается.
 * Следует разделить его на серию более простых методов (или вообще выделить отдельный класс).
 */
public class MainApplicationFrame extends AbstractWindow {

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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setLocation(10, 10);
        logWindow.setSize(300, 800);
        setMinimumSize(logWindow.getSize());
        logWindow.pack();
        Logger.debug(I18nProvider.getMessage(I18nBundles.LOG_WINDOW, "log_default_msg"));
        return logWindow;
    }

    protected GameWindow createGameWindow(){
        GameWindow gameWindow = new GameWindow();
        gameWindow.setSize(400, 400);
        return gameWindow;
    }

    protected void addWindow(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    @Override
    public void onUiChanged() {
        super.onUiChanged();
        gameWindow.onUiChanged();
        logWindow.onUiChanged();
    }
}
