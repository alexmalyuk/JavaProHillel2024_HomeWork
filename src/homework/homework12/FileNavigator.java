package homework.homework12;

import java.util.*;

public class FileNavigator {
    private final Map<String, DirectoryData> directories = new HashMap<>();

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
        if (directories.containsKey(path))
            return directories.get(path).getFiles();
        else
            return Collections.emptyList();
    }

    public List<FileData> filterBySize(int maxSize) {
        List<FileData> result = new ArrayList<>();

        for (var directoryDataEntry : directories.entrySet())
            for (FileData fileData : directoryDataEntry.getValue().getFiles())
                if (fileData.size() <= maxSize)
                    result.add(fileData);

        return result;
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = filterBySize(Integer.MAX_VALUE);
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