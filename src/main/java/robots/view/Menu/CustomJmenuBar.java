package robots.view.Menu;

import robots.model.helpz.profileManager;
import robots.model.i18n.I18nBundles;
import robots.model.i18n.I18nProvider;
import robots.model.log.Logger;
import robots.view.MainApplicationFrame;
import robots.view.ui.ProfileSaveWindow;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Locale;

public class CustomJmenuBar {
    private MainApplicationFrame screen;
    private final JMenuBar menuBar = new JMenuBar();

    public CustomJmenuBar(MainApplicationFrame screen_) {
        screen = screen_;
    }

    public CustomJmenuBar() {

    }

    public void switchLocale(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        var newLocale = new Locale(language, country);
        I18nProvider.setLocale(newLocale);
        Logger.debug(I18nProvider.getLogWindowMessage("curr_locale_is_msg") + String.valueOf(Locale.getDefault()));
        screen.updateDesktopPane();
    }

    public JMenu buildLookAndFeel() {
        JMenu menu = new JMenu(I18nProvider.getDataMessage("view_mode_button"));
        JMenuItem system = generateSchemeOption(I18nProvider.getDataMessage("sys_scheme_choice"), UIManager.getSystemLookAndFeelClassName());
        JMenuItem universal = generateSchemeOption(I18nProvider.getDataMessage("universal_scheme_choice"), UIManager.getCrossPlatformLookAndFeelClassName());

        JMenuViewBuilder lookBuilder = new JMenuViewBuilder.Builder()
                .jMenu(menu)
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(I18nProvider.getDataMessage("change_view_button"))
                .addMenuItem(universal)
                .addMenuItem(system)
                .buid();

        return lookBuilder.jMenu;
    }

    public JMenuItem generateSchemeOption(String text, String variant) {
        JMenuItem jMenuItem = new JmenuItemBuilder.Builder()
                .setMnemonic(KeyEvent.VK_S)
                .setText(text)
                .addActionListener((event) -> {
                    setLookAndFeel(variant);
                    screen.invalidate();
                })
                .buid()
                .jMenuItem;
        return jMenuItem;
    }

    public JMenu buildTestMenu() {
        JMenu testMenu = new JMenu(I18nProvider.getDataMessage("tests_button"));
        JMenuViewBuilder jMenuViewBuilder = new JMenuViewBuilder.Builder()
                .jMenu(testMenu)
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(I18nProvider.getDataMessage("test_commands_button"))
                .addMenuItem(buildTestMenuItem())
                .addMenuItem(buildGamePosMenuItem())
                .buid();
        return jMenuViewBuilder.jMenu;
    }

    public JMenuItem buildTestMenuItem() {
        JMenuItem jMenuItem = new JmenuItemBuilder.Builder()
                .setMnemonic(KeyEvent.VK_S)
                .setText(I18nProvider.getDataMessage("log_msg_choises"))
                .addActionListener((event) -> {
                    Logger.debug(I18nProvider.getDataMessage("test_msg_choise"));
                })
                .buid()
                .jMenuItem;
        return jMenuItem;
    }

    public JMenuItem buildGamePosMenuItem() {
        JMenuItem jMenuItem = new JmenuItemBuilder.Builder()
                .setMnemonic(KeyEvent.VK_S)
                .setText(I18nProvider.getLogWindowMessage("game_pos_choice"))
                .addActionListener((event) -> {
                    Logger.debug(I18nProvider.getLogWindowMessage("game_pos_does") + screen.getGameWindowPos().getX() + " " + screen.getGameWindowPos().getY());
                })
                .buid()
                .jMenuItem;
        return jMenuItem;
    }

    public JMenu buildLanguageMenu() {
        JMenu menu = new JMenu(I18nProvider.getDataMessage("locale_button"));
        JMenuViewBuilder jMenuViewBuilder = new JMenuViewBuilder.Builder()
                .jMenu(menu)
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(I18nProvider.getDataMessage("locale_description"))
                .addMenuItem(buildLanguageItem(
                        I18nProvider.getDataMessage("locale_US_choice"),
                        Locale.US
                ))
                .addMenuItem(buildLanguageItem(
                        I18nProvider.getDataMessage("locale_RU_choice"),
                        new Locale.Builder().setLanguage("ru").setRegion("RU").build()
                ))
                .buid();
        return jMenuViewBuilder.jMenu;
    }

    public JMenuItem buildLanguageItem(String optionTitle, Locale lc) {
        JMenuItem jMenuItem = new JmenuItemBuilder.Builder()
                .setMnemonic(KeyEvent.VK_S)
                .setText(optionTitle)
                .addActionListener((event) -> {
                    switchLocale(lc);
                    screen.updateUiFrames();
                    profileManager.setCurrentLocale(lc);
                })
                .buid()
                .jMenuItem;
        return jMenuItem;
    }

    public JMenu buildExitMenu() {
        JMenu menu = new JMenu(I18nProvider.getDataMessage("exit_btn"));
        JMenuViewBuilder jMenuViewBuilder = new JMenuViewBuilder.Builder()
                .jMenu(menu)
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(I18nProvider.getDataMessage("exit_btn"))
                .addMenuItem(buildExitItem())
                .buid();
        return jMenuViewBuilder.jMenu;
    }

    public JMenuItem buildExitItem() {
        JMenuItem jMenuItem = new JmenuItemBuilder.Builder()
                .setMnemonic(KeyEvent.VK_S)
                .setText(I18nProvider.getDataMessage("exit_btn"))
                .addActionListener((event) -> {
                    Object[] options = {
                            I18nProvider.getDataMessage("yes"),
                            I18nProvider.getDataMessage("no"),
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
                        ProfileSaveWindow a = screen.createProfileSaveWindow();
                        a.setVisible(true);
                    }
                })
                .buid()
                .jMenuItem;
        return jMenuItem;
    }

    public JMenuBar generateMenuBar() {
        menuBar.add(buildLookAndFeel());
        menuBar.add(buildTestMenu());
        menuBar.add(buildLanguageMenu());
        menuBar.add(buildExitMenu());
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
