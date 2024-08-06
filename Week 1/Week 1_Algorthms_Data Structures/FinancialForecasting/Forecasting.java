public class Forecasting {
    public double calculateFutureValue(double initialValue, double growthRate, int years) {
        if (years <= 0) {
            return initialValue;
        }
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Forecasting forecasting = new Forecasting();
        double initialValue = 1000;
        double growthRate = 0.05;
        int years = 10;

        double futureValue = forecasting.calculateFutureValue(initialValue, growthRate, years);
        System.out.println("Future Value: " + futureValue);
    }
}
