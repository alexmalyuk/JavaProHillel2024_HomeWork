package org.example;

public enum LoggingLevel {
    INFO(0),
    DEBUG(1)
    ;
    private int level;
    LoggingLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
}
