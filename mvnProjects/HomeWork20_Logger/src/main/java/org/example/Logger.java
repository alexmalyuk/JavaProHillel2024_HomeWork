package org.example;

import org.example.service.LoggerConfiguration;
import org.example.service.LoggerMessage;
import org.example.enums.LoggingLevel;
import org.example.service.ConfigurationLoader;
import org.example.service.MessageWriter;

public class Logger {
    private LoggerConfiguration configuration;
    private MessageWriter writer;

    private Logger() {
    }

    private void write(LoggerMessage logMessage) {
        if (logMessage.getLevel().getImportance() >= configuration.getLoggingLevel().getImportance()) {
            writer.write(logMessage);
        }
    }

    public static Logger createLogger(String configurationFilePath) {
        Logger logger = new Logger();
        logger.configuration = ConfigurationLoader.load(configurationFilePath);
        logger.writer = logger.configuration.createWriter();
        return logger;
    }

    public void debug(String str) {
        write(LoggerMessage.create(LoggingLevel.DEBUG, str));
    }

    public void info(String str) {
        write(LoggerMessage.create(LoggingLevel.INFO, str));
    }
}
