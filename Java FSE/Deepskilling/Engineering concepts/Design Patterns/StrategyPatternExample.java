interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPaymentStrategy(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using credit card: " + cardHolderName);
    }
}

class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal: " + email);
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        strategy.pay(amount);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new CreditCardPaymentStrategy("1234-5678-9876-5432", "John Doe"));
        paymentContext.executePayment(250.00);

        paymentContext.setPaymentStrategy(new PayPalPaymentStrategy("john.doe@example.com"));
        paymentContext.executePayment(120.00);
    }
}
