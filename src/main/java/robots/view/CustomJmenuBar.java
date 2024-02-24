package robots.view;

import robots.model.log.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class CustomJmenuBar {
    private JFrame screen;
    private final JMenuBar menuBar = new JMenuBar();

    public CustomJmenuBar(JFrame screen_) {
        screen = screen_;
    }

    public CustomJmenuBar() {

    }

    public JMenuBar generateMenuBar() {

        JMenuViewBuilder lookAndFeelMenuView = new JMenuViewBuilder.Builder()
                .jMenu(new JMenu("Режим отображения"))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription("Управление режимом отображения приложения")
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText("Системная схема")
                                .addActionListener((event) -> {
                                    setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                                    screen.invalidate();
                                })
                                .buid()
                                .jMenuItem
                )
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText("Универсальная схема")
                                .addActionListener((event) -> {
                                    setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                                    screen.invalidate();
                                })
                                .buid()
                                .jMenuItem
                )
                .buid();

        JMenuViewBuilder testMenuView = new JMenuViewBuilder.Builder()
                .jMenu(new JMenu("Тесты"))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription("Тестовые команды")
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText("Сообщение в лог")
                                .addActionListener((event) -> {
                                    Logger.debug("Новая строка");
                                })
                                .buid()
                                .jMenuItem
                )
                .buid();

        menuBar.add(lookAndFeelMenuView.jMenu);
        menuBar.add(testMenuView.jMenu);
        return menuBar;
    }

    private void setLookAndFeel(String className) {
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(screen);
        } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException e) {

        }
    }
}
