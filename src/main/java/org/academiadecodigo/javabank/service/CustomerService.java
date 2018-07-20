package org.academiadecodigo.javabank.service;

import org.academiadecodigo.javabank.model.customer.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {

    Customer get(int id);
    List<Customer> list();
    Set<Integer> listCustomerAccountIds(int id);
    double getBalance(int id, int accountID);
    void add(Customer customer);
    boolean UsernameInUse(String newUsername);
    boolean emailInUse(String email);
}
