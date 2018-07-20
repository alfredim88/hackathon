package org.academiadecodigo.javabank.service.jpa;

import org.academiadecodigo.javabank.model.customer.Customer;
import org.academiadecodigo.javabank.persistence.CustomerDao;
import org.academiadecodigo.javabank.service.AuthService;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;


public class JpaAuthService implements AuthService {

    private CustomerDao customerDao;
    private Integer accessingCustomerId;

    public JpaAuthService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean authenticate(String username, String password) {

        try {

            if (customerDao.findByUsername(username) == null) {
                return false;
            }

            if (!customerDao.findByUsername(username).checkPassword(password)) {
                return false;
            }

            Customer customer = customerDao.findByUsername(username);
            accessingCustomerId = customer.getId();

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }

        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public Customer getAccessingCustomer() {


        if (accessingCustomerId == null) {
            return null;
        }

        Customer customer = null;

        try {

            customer = customerDao.findById(accessingCustomerId);

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }
        return customer;
    }

    @Override
    public void logoff() {
        accessingCustomerId = null;
    }

}
