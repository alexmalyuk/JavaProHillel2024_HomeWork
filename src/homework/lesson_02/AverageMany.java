package homework.lesson_02;

public class AverageMany {
    public static void main(String[] args) {
        float[] nn = {10.5F, 20.4F, 10.78F};
        System.out.println(calcAverage(nn));
    }

    private static float calcAverage(float[] numbers) {
        float sum = 0F;

        for (float number : numbers)
            sum += number;

        return sum / (numbers.length);
    }
}
