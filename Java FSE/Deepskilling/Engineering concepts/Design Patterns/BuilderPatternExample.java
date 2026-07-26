public class Computer{
    private String ram;
    private String cpu;
    private int storage;

    public Computer(Builder builder) {
        this.ram = builder.ram;
        this.cpu = builder.cpu;
        this.storage = builder.storage;
    }
    public String getRam() {
        return ram;
    }

    public String getCpu() {
        return cpu;
    }

    public int getStorage() {
        return storage;
    }

    public static class Builder {
        private String ram;
        private String cpu;
        private int storage;

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .setRam("16GB")
                .setCpu("Intel i7")
                .setStorage(512)
                .build();

        System.out.println("Computer Configuration:");
        System.out.println("RAM: " + computer.getRam());
        System.out.println("CPU: " + computer.getCpu());
        System.out.println("Storage: " + computer.getStorage() + "GB");
    }
}