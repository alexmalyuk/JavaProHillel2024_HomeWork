package homework.lesson03;

public class Main {
    public static void main(String[] args) {
        HomeWork hW = new HomeWork();

        //1. За допомогою циклу for вивести на екран непарні числа від 1 до 99.
        hW.printOddNumbers(1, 99);

        // 2. Дано число n за допомогою циклу for порахувати факторіал n!
        hW.printFactorial(6);

        // 3. Перепишіть програми 1 та 2 за допомогою циклу while.
        hW.printOddNumbersWhile(1, 99);
        hW.printFactorialWhile(6);

        // 4. Перепишіть програми 1 та 2 із використанням циклу do - while.
        hW.printOddNumbersDoWhile(1, 99);
        hW.printFactorialDoWhile(6);

        // 5. Дано змінні x і n обчислити x^n.
        hW.printPow(2.5d, 3);

        // 6. Вивести 10 перших чисел послідовності 0, -5,-10,-15.
        hW.printTopNumbers(10);

        // 7. Необхідно вивести на екран таблицю множення на Х: (будь-яке число, що вводиться з консолі)
        hW.printMultiplicationTable();

        // 8. Створіть масив, що містить 10 перших непарних чисел. Виведіть елементи масиву на консоль в один рядок, розділяючи комою.
        int[] oddArray = hW.getOddArray(10);
        hW.printArray(oddArray);

        // 9. Даний масив розмірності N, знайти найменший елемент масиву і вивести на консоль
        // 10. У масиві із завдання 9. Визначити найбільший елемент.
        int[] array = {3, 5, -7, 0, 6, 45, 8, 90, 17};
        hW.printMinElement(array);
        hW.printMaxElement(array);

        // 11. Поміняти максимальний і найменший елементи масиву місцями.
        hW.printArray(array);
        hW.swapMinMax(array);
        hW.printArray(array);
    }
}
