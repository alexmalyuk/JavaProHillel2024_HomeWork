package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class SimpleLogger {
    private File logFile;

    public SimpleLogger(File outputDirectory) {
        try {
            this.logFile = new File(outputDirectory, "result.log");
            if (logFile.exists()) {
                logFile.delete();
            }
            logFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        try (OutputStream outputStream = new FileOutputStream(logFile, true)) {
            String str = message.concat("\n");
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
