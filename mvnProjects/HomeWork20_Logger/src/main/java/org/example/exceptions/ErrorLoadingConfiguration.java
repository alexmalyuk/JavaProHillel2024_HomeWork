package org.example.exceptions;

public class ErrorLoadingConfiguration extends RuntimeException{
    public ErrorLoadingConfiguration(String message) {
        super(message);
    }
}
