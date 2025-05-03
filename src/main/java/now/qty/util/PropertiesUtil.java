package now.qty.util;

import java.util.Properties;

public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private PropertiesUtil() {
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try {var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties");
            PROPERTIES.load(inputStream);
        } catch (Exception e) {
            System.out.println("Error loading/reading application.properties");
            throw new RuntimeException(e);
        }
    }
}