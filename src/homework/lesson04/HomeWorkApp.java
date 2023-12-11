package homework.lesson04;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();

        checkSumSign();
        checkSumSign();
        checkSumSign();
        checkSumSign();

        printColor();
        printColor();
        printColor();
        printColor();

        compareNumbers();
        compareNumbers();
        compareNumbers();
        compareNumbers();

        System.out.println(isSumFrom10To20(5, 4));
        System.out.println(isSumFrom10To20(5, 5));
        System.out.println(isSumFrom10To20(15, 4));
        System.out.println(isSumFrom10To20(15, 14));

        printNumberSign(-5);
        printNumberSign(0);
        printNumberSign(5);

        System.out.println(isNegative(-5));
        System.out.println(isNegative(0));
        System.out.println(isNegative(5));

        printString(5, "Слава Україні!");

        for (int i = 1800; i <= 2400; i++) {
            if (isLeapYear(i)) {
                System.out.println(i);
            }
        }
    }

    static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    static void checkSumSign() {
        int a = (int) (Math.random() * 100 - 50);
        int b = (int) (Math.random() * 100 - 50);
        System.out.printf("%s + %s -> %s \n", a, b, (a + b) >= 0 ? "Сума позитивна" : "Сума негативна");
    }

    static void printColor() {
        int value = (int) (Math.random() * 500 - 250);
        System.out.print("value = " + value + " - ");
        if (value <= 0) {
            System.out.println("Червоний");
        } else if (value <= 100) {
            System.out.println("Жовтий");
        } else {
            System.out.println("Зелений");
        }
    }

    static void compareNumbers() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        System.out.printf("a = %s b = %s  %s \n", a, b, a >= b ? "a >= b" : "a < b");
    }

    static boolean isSumFrom10To20(int a, int b) {
        int sum = a + b;
        return (sum >= 10) && (sum <= 20);
    }

    static void printNumberSign(int a) {
        System.out.println(a < 0 ? "Negative" : "Positive");
    }

    static boolean isNegative(int a) {
        return a < 0;
    }

    static void printString(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
}
