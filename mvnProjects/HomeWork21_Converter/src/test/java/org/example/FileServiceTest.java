package org.example;

import org.example.dto.Format;
import org.example.dto.TextData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

class FileServiceTest {

    private static final File rootDir = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + File.separator + "testdir");

    private static File createFile(String fileName, String text) {
        File file = new File(rootDir, fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    @BeforeEach
    void setUp() {
        rootDir.mkdir();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.walk(rootDir.toPath()).map(Path::toFile).forEach(File::delete);
        rootDir.delete();
    }

    @Test
    void readData() throws IOException {
        String testContent = "{\n" +
                "  \"key1\": \"value1\",\n" +
                "  \"key2\": \"value2\"\n" +
                "}\n";
        createFile("test.json", testContent);

        File file = new File(rootDir, "test.json");
        FileService fs = new FileService();
        TextData textData = fs.readFromFile(file);

        Assertions.assertEquals(testContent, textData.getContent());
    }

    @Test
    void writeData() throws IOException {
        String TEST_CONTENT = "testContent\n";
        TextData td = new TextData(Format.JSON, TEST_CONTENT);
        File file = new File(rootDir, "test" + Format.JSON.getExtension());
        FileService fs = new FileService();
        fs.writeToFile(td, file);

        StringBuilder sb = new StringBuilder();
        Stream<String> stream = Files.lines(file.toPath(), StandardCharsets.UTF_8);
        stream.forEach(s -> sb.append(s).append("\n"));

        Assertions.assertEquals(td.getContent(), sb.toString());
    }

    @Test
    void getFileList() {
        List<File> expectedList = List.of(
                createFile("test.json", "testContent"),
                createFile("test.xml", "testContent"),
                createFile("test.yaml", "testContent")
        );
        createFile("test.txt", "testContent");

        FileService fs = new FileService();
        Assertions.assertEquals(expectedList, fs.getFileList(rootDir));
    }
}