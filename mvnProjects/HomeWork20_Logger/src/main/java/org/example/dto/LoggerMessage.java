package org.example.dto;

import org.example.enums.LoggingLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerMessage {
    private final LoggingLevel level;
    private final String message;
    private final Date timeStamp = new Date();

    public LoggerMessage(LoggingLevel level, String message) {
        this.level = level;
        this.message = message;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(timeStamp) + " " + this.level + " " + this.message;
    }
}
