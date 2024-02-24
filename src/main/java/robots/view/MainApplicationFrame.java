package robots.view;

import robots.model.log.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Что требуется сделать:
 * 1. Метод создания меню перегружен функционалом и трудно читается.
 * Следует разделить его на серию более простых методов (или вообще выделить отдельный класс).
 */
public class MainApplicationFrame extends JFrame {
    private final JDesktopPane desktopPane = new JDesktopPane();

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


        LogWindow logWindow = createLogWindow();
        addWindow(logWindow);

        GameWindow gameWindow = new GameWindow();
        gameWindow.setSize(400, 400);
        addWindow(gameWindow);

        setJMenuBar(generateMenuBar());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setLocation(10, 10);
        logWindow.setSize(300, 800);
        setMinimumSize(logWindow.getSize());
        logWindow.pack();
        Logger.debug("Протокол работает");
        return logWindow;
    }

    protected void addWindow(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    private JMenuBar generateMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenuView lookAndFeelMenuView = new JMenuView.Builder()
                .jMenu(new JMenu("Режим отображения"))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription("Управление режимом отображения приложения")
                .addMenuItem(new JMenuItem("Системная схема", KeyEvent.VK_S), (event) -> {
                    setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    this.invalidate();
                })
                .addMenuItem(new JMenuItem("Универсальная схема", KeyEvent.VK_S), (event) -> {
                    setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    this.invalidate();
                })
                .buid();

        JMenuView testMenuView = new JMenuView.Builder()
                .jMenu(new JMenu("Тесты"))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription("Тестовые команды")
                .addMenuItem(new JMenuItem("Сообщение в лог", KeyEvent.VK_S), (event) -> {
                    Logger.debug("Новая строка");
                })
                .buid();

        menuBar.add(lookAndFeelMenuView.jMenu);
        menuBar.add(testMenuView.jMenu);
        return menuBar;
    }

    private void setLookAndFeel(String className) {
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // just ignore
        }
    }
}
