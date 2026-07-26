interface Image {
    void display();
}

class RealImage implements Image {
    private String imageUrl;

    public RealImage(String imageUrl) {
        this.imageUrl = imageUrl;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + imageUrl);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + imageUrl);
    }
}

class ProxyImage implements Image {
    private String imageUrl;
    private RealImage realImage;

    public ProxyImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(imageUrl);
        } else {
            System.out.println("Using cached image: " + imageUrl);
        }
        realImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("https://example.com/image.jpg");

        System.out.println("--- First display request ---");
        image.display();

        System.out.println("--- Second display request ---");
        image.display();
    }
}
