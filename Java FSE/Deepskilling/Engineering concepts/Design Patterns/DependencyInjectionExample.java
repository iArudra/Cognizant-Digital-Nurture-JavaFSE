interface CustomerRepository {
    String getCustomerById(int id);
}

class InMemoryCustomerRepository implements CustomerRepository {
    @Override
    public String getCustomerById(int id) {
        switch (id) {
            case 1:
                return "Alice Johnson";
            case 2:
                return "Bob Smith";
            default:
                return "Unknown Customer";
        }
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void printCustomer(int id) {
        System.out.println("Customer " + id + ": " + repository.getCustomerById(id));
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new InMemoryCustomerRepository();
        CustomerService service = new CustomerService(repository);

        service.printCustomer(1);
        service.printCustomer(2);
        service.printCustomer(3);
    }
}
