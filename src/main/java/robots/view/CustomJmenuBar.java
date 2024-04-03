package robots.view;

import robots.model.i18n.I18nBundles;
import robots.model.i18n.I18nProvider;
import robots.model.log.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Locale;
public class CustomJmenuBar extends AbstractWindow {
    private AbstractWindow screen;
    private final JMenuBar menuBar = new JMenuBar();

    public CustomJmenuBar(AbstractWindow screen_) {
        screen = screen_;
    }

    public CustomJmenuBar() {

    }

    private void switchLocale(Locale locale){
        String language = locale.getLanguage();
        String country = locale.getCountry();
        var newLocale = new Locale(language, country);
        I18nProvider.setLocale(newLocale);
        this.onUiChanged();
        screen.onUiChanged();
    }

    public JMenuBar generateMenuBar() {

        JMenuViewBuilder lookAndFeelMenuView = new JMenuViewBuilder.Builder()
                .jMenu(new JMenu(I18nProvider.getMessage(I18nBundles.DATA, "view_mode_button")))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(I18nProvider.getMessage(I18nBundles.DATA, "change_view_button"))
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText(I18nProvider.getMessage(I18nBundles.DATA, "sys_scheme_choice"))
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
                                .setText(I18nProvider.getMessage(I18nBundles.DATA, "universal_scheme_choice"))
                                .addActionListener((event) -> {
                                    setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                                    screen.invalidate();
                                })
                                .buid()
                                .jMenuItem
                )
                .buid();

        JMenuViewBuilder testMenuView = new JMenuViewBuilder.Builder()
                .jMenu(new JMenu(I18nProvider.getMessage(I18nBundles.DATA, "tests_button")))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(I18nProvider.getMessage(I18nBundles.DATA, "test_commands_button"))
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText(I18nProvider.getMessage(I18nBundles.DATA, "log_msg_choises"))
                                .addActionListener((event) -> {
                                    Logger.debug(I18nProvider.getMessage(I18nBundles.DATA, "test_msg_choise"));
                                })
                                .buid()
                                .jMenuItem
                )
                .buid();

        JMenuViewBuilder setLocaleMenuView = new JMenuViewBuilder.Builder()
                .jMenu(new JMenu(I18nProvider.getMessage(I18nBundles.DATA, "locale_button")))
                .setMnemonic(KeyEvent.VK_V)
                .setAccessibleDescription(I18nProvider.getMessage(I18nBundles.DATA, "locale_description"))
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText(I18nProvider.getMessage(I18nBundles.DATA, "locale_US_choice"))
                                .addActionListener((event) -> {
                                    switchLocale(Locale.US);
                                    this.onUiChanged();
                                })
                                .buid()
                                .jMenuItem
                )
                .addMenuItem(
                        new JmenuItemBuilder.Builder()
                                .setMnemonic(KeyEvent.VK_S)
                                .setText(I18nProvider.getMessage(I18nBundles.DATA, "locale_RU_choice"))
                                .addActionListener((event) -> {
                                    switchLocale(new Locale.Builder().setLanguage("ru").setRegion("RU").build());
                                    this.onUiChanged();
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

    @Override
    public void onUiChanged() {
        super.onUiChanged();
    }
}
