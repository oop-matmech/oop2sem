package robots.view;

import robots.model.log.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
import java.util.Locale;
public class CustomJmenuBar {
    private JFrame screen;
    private final JMenuBar menuBar = new JMenuBar();
    private ResourceBundle currBundle = ResourceBundle.getBundle("data", Locale.getDefault());

    public CustomJmenuBar(JFrame screen_) {
        screen = screen_;
    }

    public CustomJmenuBar() {

    }

    private void switchLocale(Locale locale){
        currBundle = ResourceBundle.getBundle("data", locale);
        Locale.setDefault(locale);
    }

    public JMenuBar generateMenuBar() {

        JMenuViewBuilder lookAndFeelMenuView = new JMenuViewBuilder.Builder()
                .jMenu(new JMenu(currBundle.getString("view_mode_button")))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(currBundle.getString("change_view_button"))
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText(currBundle.getString("sys_scheme_choice"))
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
                                .setText(currBundle.getString("universal_scheme_choice"))
                                .addActionListener((event) -> {
                                    setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                                    screen.invalidate();
                                })
                                .buid()
                                .jMenuItem
                )
                .buid();

        JMenuViewBuilder testMenuView = new JMenuViewBuilder.Builder()
                .jMenu(new JMenu(currBundle.getString("tests_button")))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(currBundle.getString("test_commands_button"))
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText(currBundle.getString("log_msg_choises"))
                                .addActionListener((event) -> {
                                    Logger.debug(currBundle.getString("test_msg_choise"));
                                })
                                .buid()
                                .jMenuItem
                )
                .buid();

        JMenuViewBuilder setLocaleMenuView = new JMenuViewBuilder.Builder()
                .jMenu(new JMenu(currBundle.getString("locale_button")))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(currBundle.getString("locale_description"))
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText(currBundle.getString("locale_US_choice"))
                                .addActionListener((event) -> {
                                    switchLocale(Locale.US);
                                })
                                .buid()
                                .jMenuItem
                )
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText(currBundle.getString("locale_RU_choice"))
                                .addActionListener((event) -> {
                                    switchLocale(new Locale.Builder().setLanguage("ru").setRegion("RU").build());
                                })
                                .buid()
                                .jMenuItem
                )
                .buid();

        menuBar.add(lookAndFeelMenuView.jMenu);
        menuBar.add(testMenuView.jMenu);
        menuBar.add(setLocaleMenuView.jMenu);
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
