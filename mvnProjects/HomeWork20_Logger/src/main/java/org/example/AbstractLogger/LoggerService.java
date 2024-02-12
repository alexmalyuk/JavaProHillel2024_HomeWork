package org.example.AbstractLogger;

import org.example.dto.LoggerMessage;

abstract public class LoggerService {
    abstract public void log(LoggerMessage message);
}
