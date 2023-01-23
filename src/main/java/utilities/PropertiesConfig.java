package utilities;

import commons.GlobalConstants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Properties;

public class PropertiesConfig {
    private final Properties properties;
    private final String propertyFilePath = GlobalConstants.getGlobalInstance().getProjectPath() + "resources/config.properties";

    private static PropertiesConfig configLoader;

    private PropertiesConfig() {
        properties = PropertiesConfig.propertyLoader(propertyFilePath);

    }

    private static Properties propertyLoader(String propertyFilePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            try {
                properties.load(reader);
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load properties file" + propertyFilePath);
            }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Configuation properties not found at" + propertyFilePath);
            }
            return properties;
        }

       public static synchronized PropertiesConfig getFileConfigReader(){
        return (configLoader == null) ? (new PropertiesConfig()) : configLoader;
       }

        public long getLongTimeout () {
            String longTimeout = properties.getProperty("longTimeout");
            if (longTimeout != null)
                return Long.parseLong(longTimeout);
            else
                throw new RuntimeException("Long timeout not found in Config file");
        }

        public long getShorTimeout () {
            String shortTimeout = properties.getProperty("shortTimeout");
            if (shortTimeout != null)
                return Long.parseLong(shortTimeout);
            else
                throw new RuntimeException("Short timeout not found in Config file");
        }

        public String getUrl () {
            String url = properties.getProperty("url");
            if (url != null)
                return url;
            else
                throw new RuntimeException("Url not found in Config file");
        }

        public String getAdminUrl () {
            String adminUrl = properties.getProperty("adminUrl");
            if (adminUrl != null)
                return adminUrl;
            else
                throw new RuntimeException("Admin Url not found in Config file");
        }


    }
