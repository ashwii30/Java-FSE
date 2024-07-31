public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        String customerInfo = service.getCustomerInfo("123");
        System.out.println(customerInfo);
    }
}
