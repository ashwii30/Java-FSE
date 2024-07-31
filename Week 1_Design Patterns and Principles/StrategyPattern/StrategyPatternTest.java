public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "A");
        PaymentStrategy payPalPayment = new PayPalPayment("a@gmail.com");

        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(150.75);

        context.setPaymentStrategy(payPalPayment);
        context.executePayment(200.50);
    }
}
