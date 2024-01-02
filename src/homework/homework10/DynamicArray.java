package homework.homework10;

import java.util.Objects;

public class DynamicArray implements Collection {
    private static final int START_MAX_SIZE = 10;
    private String[] innerArray = new String[START_MAX_SIZE];
    private int size = 0;

    private void CheckIndex(int index) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
    }

    private void extendInnerArray() {
        String[] newInnerArray = new String[(int) (innerArray.length * 1.6)];
        System.arraycopy(innerArray, 0, newInnerArray, 0, innerArray.length);
        innerArray = newInnerArray;
    }

    private void remove(int index) {
        CheckIndex(index);
        System.arraycopy(innerArray, index + 1, innerArray, index, size - index - 1);
        innerArray[--size] = null;
    }

    @Override
    public boolean add(String o) {
        if (size == innerArray.length)
            extendInnerArray();

        innerArray[size++] = o;
        return true;
    }

    @Override
    public boolean add(int index, String o) {
        CheckIndex(index);

        if (size == innerArray.length)
            extendInnerArray();

        System.arraycopy(innerArray, index, innerArray, index + 1, size - index + 1);
        innerArray[index] = o;
        size++;
        return true;
    }

    @Override
    public boolean delete(String o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(innerArray[i], o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
        CheckIndex(index);
        return innerArray[index];
    }

    @Override
    public boolean contains(String o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(innerArray[i], o))
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(Collection other) {
        if (this.size() == other.size()) {
            for (int i = 0; i < this.size(); i++) {
                if (!Objects.equals(this.get(i), other.get(i)))
                    return false;
            }
            return true;
        } else
            return false;
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < size; i++)
            innerArray[i] = null;
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++)
            result.append(innerArray[i]).append(i < size - 1 ? ", " : "");
        result.append("]");
        return result.toString();
    }

}
