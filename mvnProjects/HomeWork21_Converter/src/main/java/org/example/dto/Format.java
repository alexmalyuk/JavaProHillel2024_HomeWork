package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.exceptions.UnknownFormatException;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public enum Format {
    JSON(".json"),
    YAML(".yaml"),
    XML(".xml");

    private String extension;

    public static Format getFormat(File file) {
        String fileName = file.getName().toLowerCase();
        if (fileName.endsWith(".xml")) {
            return XML;
        } else if (fileName.endsWith(".json")) {
            return JSON;
        } else if (fileName.endsWith(".yaml") || fileName.endsWith(".yml")) {
            return YAML;
        } else {
            throw new UnknownFormatException(fileName);
        }
    }

    public static List<String> getAllExtensions() {
        return Arrays.stream(Format.values())
                .map(Format::getExtension)
                .toList();
    }
}
