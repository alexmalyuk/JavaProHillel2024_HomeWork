package homework.homework11.phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
    private final List<Record> records = new ArrayList<>();

    public void add(Record record) {
        records.add(record);
    }

    public void add(String name, String number) {
        records.add(new Record(name, number));
    }

    public Record find(String name) {
        if (name == null)
            return null;
        else
            return records.stream()
                    .filter(record -> record != null && name.equalsIgnoreCase(record.getName()))
                    .findFirst()
                    .orElse(null);
    }

    public List<Record> findAll(String name) {
        if (name == null)
            return Collections.emptyList();
        else
            return records.stream()
                    .filter(record -> record != null && name.equalsIgnoreCase(record.getName()))
                    .toList();
    }
}