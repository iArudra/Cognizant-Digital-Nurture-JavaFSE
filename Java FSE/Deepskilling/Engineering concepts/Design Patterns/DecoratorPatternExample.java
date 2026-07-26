interface Notification {
    void send(String message);
}

class BasicNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending notification: " + message);
    }
}

abstract class NotificationDecorator implements Notification {
    protected Notification wrappedNotification;

    public NotificationDecorator(Notification wrappedNotification) {
        this.wrappedNotification = wrappedNotification;
    }
}

class EmailNotification extends NotificationDecorator {
    public EmailNotification(Notification wrappedNotification) {
        super(wrappedNotification);
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        sendEmail(message);
    }

    private void sendEmail(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSNotification extends NotificationDecorator {
    public SMSNotification(Notification wrappedNotification) {
        super(wrappedNotification);
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        sendSms(message);
    }

    private void sendSms(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class PushNotification extends NotificationDecorator {
    public PushNotification(Notification wrappedNotification) {
        super(wrappedNotification);
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        sendPush(message);
    }

    private void sendPush(String message) {
        System.out.println("Push notification sent: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notification baseNotification = new BasicNotification();
        Notification emailNotification = new EmailNotification(baseNotification);
        Notification emailAndSmsNotification = new SMSNotification(emailNotification);
        Notification allChannelsNotification = new PushNotification(emailAndSmsNotification);

        System.out.println("--- Sending notification using decorator chain ---");
        allChannelsNotification.send("Your order has been shipped.");
    }
}
