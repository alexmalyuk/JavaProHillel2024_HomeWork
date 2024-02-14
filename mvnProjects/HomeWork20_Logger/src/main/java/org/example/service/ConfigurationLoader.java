package org.example.service;

import org.example.enums.LoggingLevel;
import org.example.enums.LoggingType;
import org.example.exceptions.ErrorLoadingConfigurationException;
import org.example.logers.file.FileLoggerConfiguration;
import org.example.logers.stdout.StdoutLoggerConfiguration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationLoader {

    private static Map<String, String> parseFileToMap(String filePath) throws IOException {
        Map<String, String> propertiesMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("@")) {
                    continue;
                }
                int separator = line.indexOf(":");
                if (separator > 0) {
                    String key = line.substring(0, separator).toUpperCase().trim();
                    String value = line.substring(separator + 1).trim();
                    propertiesMap.put(key, value);
                }
            }
        }
        return propertiesMap;
    }

    public static LoggerConfiguration load(String filePath) {
        LoggerConfiguration loggerConfiguration;
        Map<String, String> propertiesMap;
        try {
            propertiesMap = parseFileToMap(filePath);
            LoggingType loggingType = LoggingType.valueOf(propertiesMap.getOrDefault("TYPE", "STDOUT").toUpperCase());
            LoggingLevel loggingLevel = LoggingLevel.valueOf(propertiesMap.getOrDefault("LEVEL", "ALL").toUpperCase());

            loggerConfiguration = switch (loggingType) {
                case FILE -> FileLoggerConfiguration
                        .builder()
                        .loggingLevel(loggingLevel)
                        .path(propertiesMap.getOrDefault("FILE", "").replaceAll("\"", ""))
                        .maxFileSize(Integer.parseInt(propertiesMap.getOrDefault("MAX-SIZE", "1024")))
                        .build();
                case STDOUT -> StdoutLoggerConfiguration
                        .builder()
                        .loggingLevel(loggingLevel)
                        .build();
            };
        } catch (IOException | IllegalArgumentException e) {
            throw new ErrorLoadingConfigurationException(e.getMessage());
        }

        return loggerConfiguration;
    }

}
