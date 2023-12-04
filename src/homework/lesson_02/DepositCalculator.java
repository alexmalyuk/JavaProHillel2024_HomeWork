package homework.lesson_02;

import java.text.DecimalFormat;

public class DepositCalculator {
    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("");

        double startAmount = Double.parseDouble(args[0]);
        float annualRate = Float.parseFloat(args[1]);
        int timeInYears = Integer.parseInt(args[2]);

        System.out.println("*** Deposit calculator ***");
        System.out.println("Start amount: " + dF.format(startAmount));
        System.out.println("Interest annual rate: " + annualRate);

        System.out.printf("Predictive calculation for %d years\n", timeInYears);
        for (int n = 1; n <= timeInYears; n++) {
            double annualAmount = calcAnnualAmount(startAmount, annualRate);
            System.out.printf("Year %s -> Start amount %-,12.2f interest %-,12.2f Total amount %-,12.2f \n", n,  startAmount, annualAmount-startAmount, annualAmount);
            startAmount=annualAmount;
        }
    }

    private static double calcAnnualAmount(double Amount, float annualRate) {
        final int COMPOUNDING_FREQUENCY = 1;
        return Amount * Math.pow(1 + annualRate / 100 / COMPOUNDING_FREQUENCY, COMPOUNDING_FREQUENCY);
    }
}
