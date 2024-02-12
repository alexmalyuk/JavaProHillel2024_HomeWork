package org.example.AbstractLogger;

import org.example.enums.LoggingLevel;

import java.io.IOException;

abstract public class LoggerConfiguration {
    protected LoggingLevel loggingLevel = LoggingLevel.INFO;
    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }
    abstract public void load();
    abstract public LoggerService getService() throws IOException;
}
