package bundle;

import java.util.*;

public class LanguageManager {
    private static Locale currentLocale = new Locale("es", "ES"); // idioma inicial
    private static ResourceBundle bundle = ResourceBundle.getBundle("bundle.Bundle", currentLocale);

    public static void setLocale(Locale locale) {
        currentLocale = locale;
        bundle = ResourceBundle.getBundle("bundle.Bundle", currentLocale);
    }

    public static ResourceBundle getBundle() {
        return bundle;
    }

    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    public static void toggleLanguage() {
        if (currentLocale.getLanguage().equals("es")) {
            setLocale(new Locale("en", "GB"));
        } else {
            setLocale(new Locale("es", "ES"));
        }
    }
}
