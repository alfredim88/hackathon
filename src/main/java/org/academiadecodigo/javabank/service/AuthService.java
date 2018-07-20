package org.academiadecodigo.javabank.service;

import org.academiadecodigo.javabank.model.customer.Customer;

public interface AuthService {

    boolean authenticate(String username, String password);
    Customer getAccessingCustomer();
    void logoff();
}
