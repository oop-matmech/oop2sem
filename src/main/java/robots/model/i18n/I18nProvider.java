package robots.model.i18n;

import robots.model.utils.EncodingResolver;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nProvider {
    private I18nProvider() {
    }

    private static ResourceBundle bundle;

    public static Locale getLocale() {
        Locale defaultLocale = Locale.getDefault();
        return defaultLocale;
    }

    public static boolean isSupported(Locale l) {
        Locale[] availableLocales = Locale.getAvailableLocales();
        return Arrays.asList(availableLocales).contains(l);
    }

    public static void setLocale(Locale l) {
        Locale.setDefault(l);
    }

    public static String getBundleKeyString(I18nBundles bundleKey) {
        return switch (bundleKey) {
            case LOG_WINDOW -> "log_window";
            case GAME_WINDOW -> "game_window";
            case PROFILE_WINDOW -> "profile_window";
            default -> "data";
        };
    }

    public static String getMessage(I18nBundles bundleKey, String key) {
        bundle = ResourceBundle.getBundle(getBundleKeyString(bundleKey), new EncodingResolver());
        return bundle.getString(key);
    }

    public static String getMessage(String key, Object... arguments) {
        return MessageFormat.format(getMessage(key), arguments);
    }

    public static String getGameMessage(String key) {
        return I18nProvider.getMessage(I18nBundles.GAME_WINDOW, key);
    }

    public static String getLogWindowMessage(String key) {
        return I18nProvider.getMessage(I18nBundles.LOG_WINDOW, key);
    }

    public static String getProfileWindowMessage(String key) {
        return I18nProvider.getMessage(I18nBundles.PROFILE_WINDOW, key);
    }

    public static String getDataMessage(String key) {
        return I18nProvider.getMessage(I18nBundles.DATA, key);
    }
}