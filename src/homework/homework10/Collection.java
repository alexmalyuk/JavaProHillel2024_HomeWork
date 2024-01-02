package homework.homework10;

public interface Collection {
    boolean add(String o);

    boolean add(int index, String o);

    boolean delete(String o);

    String get(int index);

    boolean contains(String o);

    boolean equals(Collection otherCollection);

    boolean clear();

    int size();
}
