package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.CRC32;

public class FileDuplicateFinder {

    private static void printResult(Map<String, List<String>> duplicateFiles) {
        for (var entry : duplicateFiles.entrySet()) {
            System.out.println("Grouping value '" + entry.getKey() + "' - " + entry.getValue().size() + " duplicates found");
            for (var value : entry.getValue()) {
                System.out.println("\t" + value);
            }
        }
    }

    public static long calculateCRC32(Path pathFile) {
        try {
            CRC32 crc32 = new CRC32();
            crc32.update(Files.readAllBytes(pathFile));
            return crc32.getValue();
        } catch (IOException e) {
            return -1;
        }
    }

    public void findDuplicateFiles(String rootPath, Function<Path, String> groupingFunction) {
        try {
            var res = Files.walk(Path.of(rootPath))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.groupingBy(
                            groupingFunction,
                            Collectors.mapping(Path::toString, Collectors.toList())))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue().size() > 1)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            printResult(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
