package org.example;

import org.example.AbstractLogger.LoggerConfiguration;
import org.example.dto.LoggerMessage;
import org.example.AbstractLogger.LoggerService;
import org.example.enums.LoggingLevel;

import java.io.IOException;

public class Logger {
    private LoggerConfiguration configuration;
    private LoggerService service;

    public Logger(LoggerConfiguration configuration) throws IOException {
        this.configuration = configuration;
        this.service = configuration.getService();
    }

    public void debug(String message) {
        log(LoggingLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LoggingLevel.INFO, message);
    }

    private void log(LoggingLevel messageLevel, String message) {
        if (messageLevel.getPriority() >= configuration.getLoggingLevel().getPriority())
            service.log(new LoggerMessage(messageLevel, message));
    }
}
