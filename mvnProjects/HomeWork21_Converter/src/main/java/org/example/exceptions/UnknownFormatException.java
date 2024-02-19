package org.example.exceptions;

public class UnknownFormatException extends RuntimeException {
    public UnknownFormatException(String message) {
        super(message);
    }
}
