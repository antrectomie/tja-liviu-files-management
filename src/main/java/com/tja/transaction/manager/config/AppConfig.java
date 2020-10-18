package com.tja.transaction.manager.config;

import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();
    private final Properties props = new Properties();

    private AppConfig() {
        URI uri = null;
        try {
            uri = ClassLoader.getSystemClassLoader().getResource("application.properties").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try (Reader reader = Files.newBufferedReader(Paths.get(uri))) {
            props.load(reader);
            System.out.println(props);
        } catch (Exception e) {

        }
    }


    public static AppConfig getConfigInstance() {
        return APP_CONFIG;
    }


    public String getTransactionProcessedDir() {
        return props.getProperty("transaction.processed.dir");
    }

    public String getTransactionInputDir() {
        return props.getProperty("transaction.input.dir");
    }

    public String getTransactionOutputDir() {
        return props.getProperty("transaction.output.dir");
    }

    public String getTransactionErrorDir() {
        return props.getProperty("transaction.error.dir");
    }

    public String getTransactionSeparatorTxt() {
        return props.getProperty("transaction.separator.txt");
    }
}
