package com.varunbkarmikanda.lab9.college;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class AppConfig {
    private static final String CONFIG_FILE = "db.properties";
    private static final Properties PROPERTIES = loadProperties();

    private AppConfig() {
    }

    public static String getRequired(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing configuration property: " + key);
        }
        return value;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = AppConfig.class.getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IllegalStateException("Configuration file not found: " + CONFIG_FILE);
            }
            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Could not load configuration: " + CONFIG_FILE, e);
        }
    }
}
