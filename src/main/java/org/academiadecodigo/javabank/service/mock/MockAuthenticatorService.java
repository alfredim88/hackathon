package org.academiadecodigo.javabank.service.mock;

import org.academiadecodigo.javabank.model.customer.Customer;
import org.academiadecodigo.javabank.service.AuthService;

public class MockAuthenticatorService implements AuthService {

    private Customer accessingCustomer;

    @Override
    public boolean authenticate(String username, String password) {

        return false;
    }

    @Override
    public Customer getAccessingCustomer() {
        return accessingCustomer;
    }

    @Override
    public void logoff() {

    }


}
