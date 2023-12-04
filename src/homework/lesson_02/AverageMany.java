package homework.lesson_02;

public class AverageMany {
    public static void main(String[] args) {
        double[] nn = {10.5, 20.4, 10.78, 121, 456, 789};
        System.out.println(calcAverage(nn));
    }

    private static double calcAverage(double[] numbers) {
        double sum = 0;

        for (double number : numbers) {
            sum += number;
        }

        return sum / numbers.length;
    }
}
