package org.example.logers.stdout;

import lombok.Builder;
import lombok.Getter;
import org.example.service.LoggerConfiguration;
import org.example.service.MessageWriter;
import org.example.enums.LoggingLevel;

@Getter
public class StdoutLoggerConfiguration extends LoggerConfiguration {
    @Builder
    public StdoutLoggerConfiguration(LoggingLevel loggingLevel) {
        super(loggingLevel);
    }

    @Override
    public MessageWriter createWriter() {
        return new StdoutMessageWriter();
    }
}
