package org.example.ConsoleLogger;

import org.example.dto.LoggerMessage;
import org.example.AbstractLogger.LoggerService;

public class ConsoleLoggerService extends LoggerService {
    @Override
    public void log(LoggerMessage message) {
        System.out.println("Con " + message);
    }
}
