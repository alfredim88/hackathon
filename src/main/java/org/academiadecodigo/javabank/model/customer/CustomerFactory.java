package org.academiadecodigo.javabank.model.customer;

public class CustomerFactory {

    public static Customer createCustomer(String username, String password, String email){
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setEmail(email);
        return customer;
    }
}