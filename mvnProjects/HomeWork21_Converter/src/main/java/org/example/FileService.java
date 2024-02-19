package org.example;

import org.example.dto.Format;
import org.example.dto.TextData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FileService {

    public TextData readFromFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        Stream<String> stream = Files.lines(file.toPath(), StandardCharsets.UTF_8);
        stream.forEach(s -> sb.append(s).append("\n"));
        return new TextData(Format.getFormat(file), sb.toString());
    }

    public void writeToFile(TextData data, File file) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)) {
            writer.write(data.getContent());
        }
    }

    public List<File> getFileList(File inputDirectory) {
        List<File> listFiles = new ArrayList<>();
        Predicate<Path> isAllowedFile = (path) -> {
            String fileName = path.getFileName().toString().toLowerCase();
            return Format.getAllExtensions().stream().anyMatch(fileName::endsWith);
        };
        try {
            listFiles = Files.list(inputDirectory.toPath())
                    .filter(Files::isRegularFile)
                    .filter(isAllowedFile)
                    .map(Path::toFile)
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFiles;
    }
}
