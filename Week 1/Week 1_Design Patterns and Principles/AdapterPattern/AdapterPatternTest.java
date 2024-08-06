public class AdapterPatternTest {
    public static void main(String[] args) {
        PaymentProcessor oldPaymentProcessor = new OldPaymentGatewayAdapter(new OldPaymentGateway());
        PaymentProcessor newPaymentProcessor = new NewPaymentGatewayAdapter(new NewPaymentGateway());

        oldPaymentProcessor.processPayment(100.0);
        newPaymentProcessor.processPayment(200.0);
    }
}
