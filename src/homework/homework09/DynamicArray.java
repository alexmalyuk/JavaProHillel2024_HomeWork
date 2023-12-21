package homework.homework09;

import java.util.Objects;

public class DynamicArray {
    private static final int START_MAX_SIZE = 10;
    private String[] innerArray = new String[START_MAX_SIZE];
    private int size = 0;

    private void CheckIndex(int index) {
        if (index < 0 || index > size - 1)
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
    }

    private void extendInnerArray() {
        String[] newInnerArray = new String[(int) (innerArray.length * 1.6)];
        System.arraycopy(innerArray, 0, newInnerArray, 0, innerArray.length);
        innerArray = newInnerArray;
    }


    public void add(String value) {
        if (size == innerArray.length)
            extendInnerArray();

        innerArray[size++] = value;
    }

    public void add(int index, String value) {
        CheckIndex(index);

        if (size == innerArray.length)
            extendInnerArray();

        System.arraycopy(innerArray, index, innerArray, index + 1, size - index + 1);
        innerArray[index] = value;
        size++;
    }

    public void delete(int index) {
        CheckIndex(index);

        innerArray[index] = null;
    }

    public void delete(String value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(innerArray[i], value)) {
                innerArray[i] = null;
            }
        }
    }

    public String get(int index) {
        return innerArray[index];
    }

    public int Length() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("length=" + size + " [");
        for (int i = 0; i < size; i++)
            result.append(innerArray[i]).append(i < size - 1 ? ", " : "");
        result.append("]");
        return result.toString();
    }
}
