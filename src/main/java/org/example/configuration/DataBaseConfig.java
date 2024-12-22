package org.example.configuration;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
@Component
public class DataBaseConfig {
    private static final String CONFIG_FILE = "application.properties";

    private String url;
    private String user;
    private String password;

    // Constructor care încarcă proprietățile dintr-un fișier
    public DataBaseConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) throw new IOException("Fișierul de configurare " + CONFIG_FILE + " nu a fost găsit.");
            Properties properties = new Properties();
            properties.load(input);

            this.url = properties.getProperty("spring.datasource.url");
            this.user = properties.getProperty("spring.datasource.username");
            this.password = properties.getProperty("spring.datasource.password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getteri pentru proprietăți
    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
//getClass().getClassLoader().getResourceAsStream
