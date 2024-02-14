package org.example.service;

import lombok.Getter;
import org.example.enums.LoggingLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerMessage {
    @Getter
    private LoggingLevel level;
    private String message;
    private final Date timeStamp = new Date();

    private LoggerMessage() {
    }

    public static LoggerMessage create(LoggingLevel level, String message) {
        var loggerMessage = new LoggerMessage();
        loggerMessage.level = level;
        loggerMessage.message = message;
        return loggerMessage;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(timeStamp) + " " + this.level + " " + this.message;
    }
}
