package org.example.enums;

import lombok.Getter;

@Getter
public enum LoggingLevel {
    /*
    Generally speaking, the logging framework is organized by the following logging levels, which are listed below in
    descending order of urgency or importance:

    Fatal: This log level indicates that at least one system component is inoperable which is causing a fatal error within the larger system.
    Error: This log entry notes that at least one system component is inoperable and is interfering with the operability of other functionalities.
    Warn: This log message indicates that an unexpected event has occurred in an application that may disrupt or delay other processes.
    Info: This log level captures an event that has occurred, though it does not appear to affect operations.
            These alerts usually can be ignored, assuming the rest of the system continues to operate normally.
    Debug: The debug log captures relevant detail of events that may be useful during software debugging or troubleshooting within the test environment.
    Trace: This log level captures the execution of code. It is considered an info message and does not require action.
            That said, it may prove useful when the team needs full visibility within the application or a third-party library.

    Some systems also rely on one of the following catch-all categories, which may serve as a default log level:
    All: All activity and events are added to the logger.
    Off: No activity or events are added to the logger.
     */
    ALL(0),
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5),
    FATAL(6),
    OFF(99);

    private final int importance;

    LoggingLevel(int importance) {
        this.importance = importance;
    }
}
