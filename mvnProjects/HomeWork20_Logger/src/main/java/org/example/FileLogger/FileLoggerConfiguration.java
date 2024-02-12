package org.example.FileLogger;

import org.example.AbstractLogger.LoggerConfiguration;
import org.example.AbstractLogger.LoggerService;
import org.example.enums.LoggingLevel;
import org.example.exceptions.ErrorLoadingConfiguration;

import java.io.IOException;
import java.util.Arrays;

public class FileLoggerConfiguration extends LoggerConfiguration {
    private String path;

    public String getPath() {
        return path;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    private int maxFileSize;

    @Override
    public void load() {
        try {
            loggingLevel = LoggingLevel.DEBUG;
            path = "mvnProjects/HomeWork20_Logger/src/main/java/org/example/logs";
            maxFileSize = 1000;
        } catch (Exception e) {
            throw new ErrorLoadingConfiguration("Error loading configuration");
        }
    }

    @Override
    public LoggerService getService() throws IOException {
        return new FileLoggerService(this);
    }
}
