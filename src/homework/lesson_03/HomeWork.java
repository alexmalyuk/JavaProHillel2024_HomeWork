package homework.lesson_03;

import java.util.Scanner;

public class HomeWork {

    public void printOddNumbers(int startNumber, int endNumber) {

        for (int i = startNumber; i <= endNumber; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public void printFactorial(int n) {

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.printf("Factorial of %s is %s \n", n, fact);
    }

    public void printOddNumbersWhile(int startNumber, int endNumber) {

        while (startNumber <= endNumber) {
            if (startNumber % 2 != 0) {
                System.out.print(startNumber + " ");
            }
            startNumber++;
        }
        System.out.println();
    }

    public void printFactorialWhile(int n) {

        long fact = 1;
        int i = 1;
        while (i <= n) {
            fact *= i;
            i++;
        }
        System.out.printf("Factorial of %s is %s \n", n, fact);
    }

    public void printOddNumbersDoWhile(int startNumber, int endNumber) {

        do {
            if (startNumber % 2 != 0) {
                System.out.print(startNumber + " ");
            }
            startNumber++;
        } while (startNumber <= endNumber);

        System.out.println();
    }

    public void printFactorialDoWhile(int n) {

        long fact = 1;
        int i = 1;
        do {
            fact *= i;
            i++;
        } while (i <= n);

        System.out.printf("Factorial of %s is %s \n", n, fact);
    }

    public void printPow(double x, int n) {

        for (int i = 1; i < n; i++) {
            x *= x;
        }
        System.out.println(x);
    }

    public void printTopNumbers(int n) {
        int a = -5;
        for (int i = 0; i < n; i++) {
            System.out.print(i * a + " ");
        }
        System.out.println();
    }

    public void printMultiplicationTable() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int n = scanner.nextInt();

        for (int i = 1; i < 11; i++) {
            System.out.printf("%s x %s = %s \n", n, i, n * i);
        }
    }

    public int[] getOddArray(int sizeArray) {
        int[] array = new int[sizeArray];

//        int i = 0;
//        int nextInt = 0;
//        while (i < sizeArray){
//            if (nextInt % 2 != 0) {
//                array[i++] = nextInt;
//            }
//            nextInt++;
//        }

        for (int i = 0; i < (sizeArray * 2); i++) {
            if (i % 2 != 0)
                array[i / 2] = i;
        }

        return array;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i < (array.length - 1) ? ", " : ""));
        }
        System.out.println();
    }

    public void printMinElement(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int n : array) {
            if (n < min) {
                min = n;
            }
        }

        System.out.println(min);
    }

    public void printMaxElement(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int n : array) {
            if (n > max) {
                max = n;
            }
        }

        System.out.println(max);
    }

    public void swapMinMax(int[] array) {
        int minElement = Integer.MAX_VALUE;
        int minIndex = 0;
        int maxElement = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
                minIndex = i;
            }
            if (array[i] > maxElement) {
                maxElement = array[i];
                maxIndex = i;
            }
        }

        if (minIndex != maxIndex) {
            int tmp = array[minIndex];
            array[minIndex] = array[maxIndex];
            array[maxIndex] = tmp;
        }
    }
}
