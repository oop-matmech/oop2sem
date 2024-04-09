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
}