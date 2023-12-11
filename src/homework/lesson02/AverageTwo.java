package homework.lesson02;

public class AverageTwo {
    public static void main(String[] args) {
        System.out.println(calcAverage(123.456F, 987.654F));
    }
    private static float calcAverage(float f1, float f2) {
        return (f1 + f2) / 2;
    }
}