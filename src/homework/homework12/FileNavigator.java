package homework.homework12;

import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {
    private final Map<String, DirectoryData> directories = new HashMap<>();

    private List<FileData> getAllFiles() {
        List<FileData> allFiles = new ArrayList<>();
        for (DirectoryData dir : directories.values())
            allFiles.addAll(dir.getFiles());
        return allFiles;
    }

    public void addPath(String path) {
        directories.put(path, new DirectoryData());
    }

    public void add(FileData file) {
        if (directories.containsKey(file.path()))
            directories.get(file.path()).add(file);
        else
            System.out.println("Cannot add " + file + " because specified path does not exist in FileNavigator");
    }

    public List<FileData> find(String path) {
        return directories.getOrDefault(path, new DirectoryData()).getFiles();
    }

    public List<FileData> filterBySize(int maxSize) {
        return getAllFiles().stream()
                .filter(fileData -> fileData.size() <= maxSize)
                .collect(Collectors.toList());
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = getAllFiles();
        allFiles.sort(Comparator.comparing(FileData::size));
        return allFiles;
    }

    public void remove(String path) {
        directories.remove(path);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FileNavigator{\n");

        for (var directoryDataEntry : directories.entrySet()) {
            sb.append(directoryDataEntry.getKey()).append(" - ");
            sb.append(directoryDataEntry.getValue()).append('\n');
        }

        sb.append('}');
        return sb.toString();
    }
}
