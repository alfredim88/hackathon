package org.academiadecodigo.javabank.service.jpa;

import org.academiadecodigo.javabank.model.customer.Customer;
import org.academiadecodigo.javabank.persistence.CustomerDao;
import org.academiadecodigo.javabank.service.CustomerService;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public class JpaCustomerService implements CustomerService {

    private CustomerDao customerDao;

    public JpaCustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional
    @Override
    public void add(Customer customer) {

        try {

            customerDao.saveOrUpdate(customer);

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Customer get(int id) {

        Customer customer;

        customer = customerDao.findById(id);

        return customer;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> list() {

        List<Customer> customers = null;

        try {

            customers = customerDao.findAll();

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }

        return customers;
    }

    @Transactional(readOnly = true)
    @Override
    public  Set<Integer> listCustomerAccountIds(int id){

        Set<Integer> accountsIDs = null;

        try{
        accountsIDs = customerDao.listCustomerAccountIds(id);

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }

        return accountsIDs;
    }

    @Transactional(readOnly = true)
    @Override
    public  double getBalance(int id, int accountID){

        double balance = 0;

        try {

        balance = customerDao.getBalance(id, accountID);

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }

        return balance;
    }


    @Transactional(readOnly = true)
    @Override
    public boolean UsernameInUse(String newUsername) {

        for (Customer customer: list()) {
            if (customer.getUsername().equals(newUsername)){
                return true;
            }
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean emailInUse(String newEmail) {
        for (Customer customer: list()) {
            if (customer.getEmail().equals(newEmail)){
                return true;
            }
        }
        return false;
    }
}
