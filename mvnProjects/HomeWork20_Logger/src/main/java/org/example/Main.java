package org.example;

import org.example.ConsoleLogger.ConsoleLoggerConfiguration;
import org.example.FileLogger.FileLoggerConfiguration;
import org.example.AbstractLogger.LoggerConfiguration;
import org.example.enums.LoggingLevel;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        LoggerConfiguration fileConfig = new FileLoggerConfiguration();
        fileConfig.load();
        Logger fileLogger = new Logger(fileConfig);

        fileLogger.info("Some info Юлічка ");
        fileLogger.debug("Some debug ");


        LoggerConfiguration consoleConfig = new ConsoleLoggerConfiguration(LoggingLevel.INFO);
        Logger consoleLogger = new Logger(consoleConfig);
        consoleLogger.info("Some info");
        consoleLogger.debug("Some debug");

    }
}