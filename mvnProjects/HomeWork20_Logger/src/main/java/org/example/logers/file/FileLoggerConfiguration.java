package org.example.logers.file;

import lombok.Builder;
import lombok.Getter;
import org.example.service.LoggerConfiguration;
import org.example.enums.LoggingLevel;
import org.example.service.MessageWriter;

@Getter
public class FileLoggerConfiguration extends LoggerConfiguration {
    private final String path;
    private final int maxFileSize;

    @Builder
    private FileLoggerConfiguration(LoggingLevel loggingLevel, String path, int maxFileSize) {
        super(loggingLevel);
        this.path = path;
        this.maxFileSize = maxFileSize;
    }

    @Override
    public MessageWriter createWriter() {
        return new FileMessageWriter(this);
    }
}
