package org.academiadecodigo.javabank.service;

import org.academiadecodigo.javabank.model.account.Account;

public interface AccountService {

    Integer add(Account account);
    void deposit(int id, double amount);
    void withdraw(int id, double amount);
    void transfer(int srcId, int dstId, double amount);
    boolean accountExists(int accountID);
    void addToCustomer(Integer accId, Integer customerId);
}
