package org.example.logers.stdout;

import org.example.service.LoggerMessage;
import org.example.service.MessageWriter;

public class StdoutMessageWriter extends MessageWriter {
    @Override
    public void write(LoggerMessage message) {
        System.out.println(message);
    }
}
