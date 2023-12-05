package homework.lesson_02;

public class DepositCalculator {
    public static void main(String[] args) {
        double startAmount = Double.parseDouble(args[0]);
        float annualRate = Float.parseFloat(args[1]);
        int timeInYears = Integer.parseInt(args[2]);

        System.out.println("*** Deposit calculator ***");
        System.out.printf("Start amount: %,.2f \n", startAmount);
        System.out.printf("Interest annual rate: %s%%\n", annualRate);
        System.out.printf("Predictive calculation for %d years:\n", timeInYears);

        for (int n = 1; n <= timeInYears; n++) {
            double annualAmount = getAnnualAmount(startAmount, annualRate);
            System.out.printf("Year %d -> Start amount %-,12.2f interest %-,12.2f Total amount %-,12.2f \n",
                    n, startAmount, annualAmount - startAmount, annualAmount);
            startAmount = annualAmount;
        }
    }

    private static double getAnnualAmount(double Amount, float annualRate) {
        final int COMPOUNDING_FREQUENCY = 365;
        return Amount * Math.pow(1 + annualRate / 100 / COMPOUNDING_FREQUENCY, COMPOUNDING_FREQUENCY);
    }
}
