package org.example.exceptions;

public class ErrorCreatingLogFileException extends RuntimeException{
    public ErrorCreatingLogFileException(String message) {
        super(message);
    }
}
