package homework.homework11.phonebook;

import java.util.ArrayList;
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
        if (name != null)
            for (Record record : records)
                if (record != null && name.equalsIgnoreCase(record.getName()))
                    return record;
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> result = new ArrayList<>();

        if (name != null)
            for (Record record : records)
                if (record != null && name.equalsIgnoreCase(record.getName()))
                    result.add(record);

        return result;
    }
}