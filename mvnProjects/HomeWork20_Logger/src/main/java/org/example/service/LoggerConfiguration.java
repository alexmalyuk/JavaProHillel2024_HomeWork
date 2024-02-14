package org.example.service;

import lombok.Getter;
import org.example.enums.LoggingLevel;
import org.example.service.MessageWriter;

@Getter
public class LoggerConfiguration {

    protected LoggingLevel loggingLevel;

    public LoggerConfiguration(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public MessageWriter createWriter() {
        return new MessageWriter();
    }

}
