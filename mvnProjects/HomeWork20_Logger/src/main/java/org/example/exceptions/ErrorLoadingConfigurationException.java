package org.example.exceptions;

public class ErrorLoadingConfigurationException extends RuntimeException {
    public ErrorLoadingConfigurationException(String message) {
        super(message);
    }
}
