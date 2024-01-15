package homework.homework14;

import homework.homework14.exeptions.*;

public class Main {
    public static void main(String[] args) {
        ArrayValueCalculator calculator = new ArrayValueCalculator();

        String[][] correctArray = {{
                "1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        String[][] incorrectSizeArray = {{
                "1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"5", "8"},
                {"9", "10", "11", "12"}};
        String[][] incorrectDataArray = {{
                "1", "2", "3", "4"},
                {"5", "6", "7", "bug is here"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};

        try {
            System.out.println(calculator.doCalc(correctArray));
            System.out.println(calculator.doCalc(incorrectSizeArray));
            System.out.println(calculator.doCalc(incorrectDataArray));
        } catch (ArrayDataException | ArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }
}
