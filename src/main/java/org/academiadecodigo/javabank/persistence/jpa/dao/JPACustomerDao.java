package org.academiadecodigo.javabank.persistence.jpa.dao;

import org.academiadecodigo.javabank.model.customer.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.CustomerDao;
import org.academiadecodigo.javabank.persistence.SessionManager;

import javax.persistence.TypedQuery;
import java.util.Set;

public class JPACustomerDao extends JPAGenericDao<Customer> implements CustomerDao {


    public JPACustomerDao() {
        super(Customer.class);
    }

    @Override
    public double getBalance(int id, int accountID) {

        Set<Account> accounts;

        accounts = em.find(Customer.class, id).getAccounts();

        for (Account account : accounts) {
            if (account.getId() == accountID) {
                return account.getBalance();
            }
        }

        return 0;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(int id) {
        return em.find(Customer.class, id).getAccountsIDs();
    }

    @Override
    public Customer findByEmail(String email) {
        TypedQuery<Customer> query =
                em.createQuery("SELECT customer FROM Customer customer WHERE customer.email = :email", Customer.class);

        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public Customer findByUsername(String username) {

        TypedQuery<Customer> query =
                em.createQuery("SELECT customer FROM Customer customer WHERE customer.username = :username", Customer.class);

        query.setParameter("username", username);
        return query.getSingleResult();
    }

}
