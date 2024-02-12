package org.example.FileLogger;

import org.example.AbstractLogger.LoggerService;
import org.example.dto.LoggerMessage;
import org.example.exceptions.FileMaxSizeReachedException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerService extends LoggerService {
    private String logFileName;
    //private File file;
    private FileLoggerConfiguration configuration;

    private void checkCreateDir() {
        File dir = new File(configuration.getPath());
        if (!dir.exists())
            dir.mkdirs();
    }

    private void checkCreateLogFile() throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = dateFormat.format(new Date());

        File file = new File(configuration.getPath(), fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        logFileName = file.getAbsolutePath();
    }

    private void checkFileSize() {
        File file = new File(logFileName);
        if (file.length() > configuration.getMaxFileSize()) {
            String str = new StringBuilder("File ").append(logFileName)
                    .append(" size ").append(file.length()).append(" bytes")
                    .append(" reached maximum ").append(configuration.getMaxFileSize()).append(" bytes").toString();
            throw new FileMaxSizeReachedException(str);
        }
    }

    public FileLoggerService(FileLoggerConfiguration configuration) throws IOException {
        this.configuration = configuration;
        checkCreateDir();
        checkCreateLogFile();
    }

    @Override
    public void log(LoggerMessage message) {
        checkFileSize();

        try (OutputStream outputStream = new FileOutputStream(logFileName, true)) {
            String str = message.toString()+"\n";
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
