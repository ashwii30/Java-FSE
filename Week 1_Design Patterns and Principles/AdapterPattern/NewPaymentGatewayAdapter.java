public class NewPaymentGatewayAdapter implements PaymentProcessor {
    private NewPaymentGateway newPaymentGateway;

    public NewPaymentGatewayAdapter(NewPaymentGateway newPaymentGateway) {
        this.newPaymentGateway = newPaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        newPaymentGateway.executePayment(amount);
    }
}
