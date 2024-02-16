package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String rootPath = "mvnProjects/HomeWork20_FindFileDublicate";
        FileDuplicateFinder finder = new FileDuplicateFinder();

        System.out.println("\n-- By name --");
        finder.findDuplicateFiles(rootPath, path -> path.getFileName().toString());

        System.out.println("\n-- By size --");
        finder.findDuplicateFiles(rootPath, path -> String.valueOf(path.toFile().length()));

        System.out.println("\n-- By CRC --");
        finder.findDuplicateFiles(rootPath, path -> String.valueOf(FileDuplicateFinder.calculateCRC32(path)));

        System.out.println("\n-- By modified day --");
        finder.findDuplicateFiles(rootPath, path -> {
            Date date = new Date(path.toFile().lastModified());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
            return simpleDateFormat.format(date);
        });

        System.out.println("\n-- By creation day --");
        finder.findDuplicateFiles(rootPath, path -> {
            BasicFileAttributes attrs;
            try {
                attrs = Files.readAttributes(path, BasicFileAttributes.class);
            } catch (IOException e) {
                return "";
            }
            FileTime fileTime = attrs.creationTime();
            Date date = new Date(fileTime.toMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
            return simpleDateFormat.format(date);
        });
    }
}