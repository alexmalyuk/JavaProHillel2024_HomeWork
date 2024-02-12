package org.example.enums;

public enum LoggingLevel {
    INFO(0),
    DEBUG(1)
    ;
    private int priority;
    LoggingLevel(int level) {
        this.priority = level;
    }
    public int getPriority() {
        return priority;
    }
}
