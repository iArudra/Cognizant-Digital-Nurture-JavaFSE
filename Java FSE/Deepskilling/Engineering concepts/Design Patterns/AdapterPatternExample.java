public interface PaymentProcessor {
    void processPayment(double amount);
}
public class UpiGateway {
    public void payViaUpi(double amount) {
        System.out.println("Paying via UPI: " + amount);
    }
}
public class CreditCardGateway {
    public void payViaCreditCard(double amount) {
        System.out.println("Paying via Credit Card: " + amount);
    }
}
public class UpiPaymentProcessor implements PaymentProcessor {
    private UpiGateway upiGateway;
    public UpiPaymentProcessor(UpiGateway upiGateway) {
        this.upiGateway = upiGateway;
    }
    @Override
    public void processPayment(double amount) {
        upiGateway.payViaUpi(amount);
    }
}
public class CreditCardPaymentProcessor implements PaymentProcessor {
    private CreditCardGateway creditCardGateway;
    public CreditCardPaymentProcessor(CreditCardGateway creditCardGateway) {
        this.creditCardGateway = creditCardGateway;
    }
    @Override
    public void processPayment(double amount) {
        creditCardGateway.payViaCreditCard(amount);
    }
}
public class AdapterPatternExample {
    public static void main(String[] args) {
        UpiGateway upiGateway = new UpiGateway();
        PaymentProcessor upiPaymentProcessor = new UpiPaymentProcessor(upiGateway);
        upiPaymentProcessor.processPayment(100.0);

        CreditCardGateway creditCardGateway = new CreditCardGateway();
        PaymentProcessor creditCardPaymentProcessor = new CreditCardPaymentProcessor(creditCardGateway);
        creditCardPaymentProcessor.processPayment(200.0);
    }
}