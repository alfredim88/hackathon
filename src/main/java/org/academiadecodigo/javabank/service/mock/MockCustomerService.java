package org.academiadecodigo.javabank.service.mock;

import org.academiadecodigo.javabank.model.customer.Customer;
import org.academiadecodigo.javabank.service.CustomerService;

import java.util.List;
import java.util.Set;

public class MockCustomerService implements CustomerService {

    //Future data base
    private MockCustomerService customerService;

    @Override
    public Customer get(int id) {
        return null;
    }

    @Override
    public List<Customer> list() {
        return null;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(int id) {

            return null;
    }

    @Override
    public double getBalance(int id, int accountID) {

        return 0;
    }

    @Override
    public void add(Customer customer) {
    }

    @Override
    public boolean UsernameInUse(String newUsername) {
        return false;
    }

    @Override
    public boolean emailInUse(String email) {
        return false;
    }

}
