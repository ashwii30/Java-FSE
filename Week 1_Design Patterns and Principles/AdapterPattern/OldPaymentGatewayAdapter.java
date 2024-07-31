public class OldPaymentGatewayAdapter implements PaymentProcessor {
    private OldPaymentGateway oldPaymentGateway;

    public OldPaymentGatewayAdapter(OldPaymentGateway oldPaymentGateway) {
        this.oldPaymentGateway = oldPaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        oldPaymentGateway.makePayment(amount);
    }
}
