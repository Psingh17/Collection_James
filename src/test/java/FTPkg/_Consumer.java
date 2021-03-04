package FTPkg;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Customer pranav =new Customer("Pranav","8527573529");
        greetCustomer(pranav);
        greetCustomerConsumer.accept(pranav);
        greetCustomerBiConsumer.accept(pranav,false);

    }

    static void greetCustomer(Customer customer){
        System.out.println("Thanks "+customer.name+" for registering with "+customer.phoneNumber);
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Thanks "+customer.name+" for registering with "+customer.phoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = ((customer, aBoolean) -> System.out.println("Thanks "+customer.name+" for registering with "+(aBoolean ? customer.phoneNumber:"*****")));

    static class Customer{
        private final String name;
        private final String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
