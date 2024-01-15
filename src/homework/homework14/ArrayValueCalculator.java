package homework.homework14;

import homework.homework14.exeptions.*;

public class ArrayValueCalculator {
    private static void throwSizeException() {
        throw new ArraySizeException("Invalid array size. Should be 4x4");
    }

    public int doCalc(String[][] arr) {
        if (arr == null || arr.length != 4)
            throwSizeException();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null || arr[i].length != 4)
                throwSizeException();
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(String.format("Invalid number format in cell [%s, %s] = '%s'", i, j, arr[i][j]));
                }
            }
        }
        return sum;
    }
}
