package org.example;

public class Main {
    public static void main(String[] args) {
        String rootPath = "mvnProjects/HomeWork20_FindFileDublicate";   ///src/main/java/org/example/";
        FileDuplicateFinder finder = new FileDuplicateFinder();

        System.out.println("\n-- By name --");
        finder.findDuplicateFiles(rootPath, path -> path.getFileName().toString());

        System.out.println("\n-- By size --");
        finder.findDuplicateFiles(rootPath, path -> String.valueOf(path.toFile().length()));

        System.out.println("\n-- By CRC --");
        finder.findDuplicateFiles(rootPath, path -> String.valueOf(FileDuplicateFinder.calculateCRC32(path)));
    }
}