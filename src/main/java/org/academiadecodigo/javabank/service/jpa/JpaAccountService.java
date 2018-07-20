package org.academiadecodigo.javabank.service.jpa;

import org.academiadecodigo.javabank.model.customer.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.AccountDao;
import org.academiadecodigo.javabank.persistence.CustomerDao;
import org.academiadecodigo.javabank.service.AccountService;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

public class JpaAccountService implements AccountService {

    private AccountDao accountDao;
    private CustomerDao customerDao;

    public JpaAccountService(AccountDao accountDao, CustomerDao customerDao) {
        this.accountDao = accountDao;
        this.customerDao = customerDao;
    }

    @Transactional
    @Override
    public Integer add(Account account) {

            Integer id = null;
        try {

            id = accountDao.saveOrUpdate(account).getId();

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }

        return id;
    }

    @Transactional
    @Override
    public void deposit(int id, double amount) {

        try {
            if (!accountDao.findById(id).canCredit(amount)) {
                return;
            }
            Account account = accountDao.findById(id);
            account.credit(amount);
            accountDao.saveOrUpdate(account);

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }

    }

    @Transactional
    @Override
    public void withdraw(int id, double amount) {

        try{

        if (!accountDao.findById(id).canDebit(amount)) {
            return;
        }

        Account account = accountDao.findById(id);
        account.debit(amount);
        accountDao.saveOrUpdate(account);

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }
    }

    @Transactional
    @Override
    public void transfer(int srcId, int dstId, double amount) {

        try {

            if (!accountDao.findById(srcId).canDebit(amount)) {
                return;
            }

            if (!accountDao.findById(dstId).canCredit(amount)) {
                return;
            }

            Account srcAccount = accountDao.findById(srcId);
            srcAccount.debit(amount);
            accountDao.saveOrUpdate(srcAccount);

            Account dstAccount = accountDao.findById(dstId);
            dstAccount.credit(amount);
            accountDao.saveOrUpdate(dstAccount);

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public boolean accountExists(int accountID) {
        return accountDao.findById(accountID) != null;
    }

    @Transactional
    @Override
    public void addToCustomer(Integer accId, Integer customerId) {

        Customer customer;
        Account account;

        try {

            customer = customerDao.findById(customerId);
            account = accountDao.findById(accId);
            customer.getAccounts().add(account);
            account.setCustomer(customer);
            customerDao.saveOrUpdate(customer);

        } catch (TransactionException te){
            System.out.println(te.getMessage());
        }
    }
}
