package homework.homework12;

import java.util.ArrayList;
import java.util.List;

public class DirectoryData {
    private final List<FileData> files = new ArrayList<>();

    public void add(FileData file) {
        files.add(file);
    }

    public List<FileData> getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "DirectoryData{" +
                "files=" + files +
                '}';
    }

}
