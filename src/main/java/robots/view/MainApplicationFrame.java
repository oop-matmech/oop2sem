package robots.view;

import robots.model.log.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ------- сделано ---------
 * Что требуется сделать:
 * 1. Метод создания меню перегружен функционалом и трудно читается.
 * Следует разделить его на серию более простых методов (или вообще выделить отдельный класс).
 */
public class MainApplicationFrame extends JFrame {
    private final JDesktopPane desktopPane = new JDesktopPane();

    private final GameWindow gameWindow = new GameWindow();

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

        gameWindow.setSize(400, 400);
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

        Logger.debug(ResourceBundle.getBundle("log_window", Locale.getDefault()).getString("log_default_msg"));
        // Logger.debug("Новая строка");
        return logWindow;
    }

    protected void addWindow(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    public void setTitle(){
        gameWindow.setTitle(ResourceBundle.getBundle("game_window", Locale.getDefault()).getString("game_window_name"));
        gameWindow.setTitle(ResourceBundle.getBundle("log_window", Locale.getDefault()).getString("log_window_name"));
    }
}
