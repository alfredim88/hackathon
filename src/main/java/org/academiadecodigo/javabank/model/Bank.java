package org.academiadecodigo.javabank.model;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.customer.Customer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The bank entity
 */
public class Bank {

    private Set<Customer> customers;
    private Map<Integer, Account> accountMap;

    public Bank() {
        this.accountMap = new HashMap<>();
        this.customers = new HashSet<>();
    }

    public Customer getCustomerByID(int id){
        for (Customer customer : customers) {
           if (customer.getId() == id){
               return customer;
           }
        }
        return null;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Map<Integer, Account> getAccountMap() {
        return accountMap;
    }

}
