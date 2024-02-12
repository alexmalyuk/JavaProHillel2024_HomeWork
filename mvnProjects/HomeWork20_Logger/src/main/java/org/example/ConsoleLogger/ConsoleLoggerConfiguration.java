package org.example.ConsoleLogger;

import org.example.AbstractLogger.LoggerConfiguration;
import org.example.AbstractLogger.LoggerService;
import org.example.enums.LoggingLevel;

public class ConsoleLoggerConfiguration extends LoggerConfiguration {
    @Override
    public void load() {
    }

    public ConsoleLoggerConfiguration(LoggingLevel loggingLevel) {
        this.loggingLevel=loggingLevel;
    }

    @Override
    public LoggerService getService() {
        return new ConsoleLoggerService();
    }
}
