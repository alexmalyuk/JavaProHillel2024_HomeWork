package homework.lesson_02;

public class Deposit {
    public static void main(String[] args) {

        double deposit = 100.00d;
        float rate = 14.5f;
        int months = 12;

        System.out.println("start sum: " + deposit);
        System.out.println("rate: " + rate);
        System.out.println("months: " + months);

        System.out.println("final sum " + calcYearPercent(deposit, rate, months));
    }

    private static double calcYearPercent(double deposit, float yearlyRate, int monthCount) {
        // складні проценти (нарахування щомісяця)
        // суми цілочисленні в копійках

        long depositInCents = Math.round(deposit * 100);
        for (int i = 0; i < monthCount; i++)
            depositInCents += Math.round(depositInCents * yearlyRate / 100 / 12);
        return depositInCents / 100.0d;
    }
}
