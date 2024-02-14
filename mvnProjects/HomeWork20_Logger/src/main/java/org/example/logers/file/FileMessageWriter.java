package org.example.logers.file;

import org.example.service.MessageWriter;
import org.example.service.LoggerMessage;
import org.example.exceptions.ErrorCreatingLogFileException;
import org.example.exceptions.FileMaxSizeReachedException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMessageWriter extends MessageWriter {
    private String logFileName;
    private final FileLoggerConfiguration configuration;

    private void checkCreateDir() {
        File dir = new File(configuration.getPath());
        dir.mkdirs();
    }

    private void createLogFile() {
        String fileNamePrefix = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        for (int i = 0; true; i++) {
            File file = new File(configuration.getPath(), fileNamePrefix + (i > 0 ? "_" + i : "") + ".txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new ErrorCreatingLogFileException(e.getMessage() + " '" + file.getAbsolutePath() + "'");
            }
            if (file.length() < configuration.getMaxFileSize()) {
                logFileName = file.getAbsolutePath();
                return;
            }
        }
    }

    private void checkFileSize() {
        File file = new File(logFileName);
        if (file.length() > configuration.getMaxFileSize()) {
            throw new FileMaxSizeReachedException(" Max size reached '" + logFileName + "'");
        }
    }

    public FileMessageWriter(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        checkCreateDir();
        createLogFile();
    }

    @Override
    public void write(LoggerMessage message) {

        try {
            checkFileSize();
        } catch (FileMaxSizeReachedException e) {
            createLogFile();
        }

        try (OutputStream outputStream = new FileOutputStream(logFileName, true)) {
            String str = message.toString() + "\n";
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
