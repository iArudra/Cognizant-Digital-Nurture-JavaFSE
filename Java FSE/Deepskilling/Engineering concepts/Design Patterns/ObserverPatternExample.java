import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(String stockSymbol, double price);
}

class StockMarket implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String stockSymbol;
    private double price;

    public void setStockPrice(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Investor " + name + " received update: " + stockSymbol + " is now " + price);
    }
}

class Broker implements Observer {
    private String firmName;

    public Broker(String firmName) {
        this.firmName = firmName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Broker " + firmName + " received update: " + stockSymbol + " price changed to " + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer investor = new Investor("Alice");
        Observer broker = new Broker("EagleTrading");

        stockMarket.registerObserver(investor);
        stockMarket.registerObserver(broker);

        System.out.println("--- First stock price update ---");
        stockMarket.setStockPrice("ACME", 135.50);

        System.out.println("--- Second stock price update ---");
        stockMarket.setStockPrice("ACME", 142.75);
    }
}
