package org.academiadecodigo.javabank.persistence;

import org.academiadecodigo.javabank.model.customer.Customer;

import java.util.Set;

public interface CustomerDao extends Dao<Customer>{

    double getBalance(int id, int accountID);
    Set<Integer> listCustomerAccountIds(int id);
    Customer findByEmail(String email);
    Customer findByUsername(String username);
}
