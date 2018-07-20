package org.academiadecodigo.javabank.service.mock;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.language.English;
import org.academiadecodigo.javabank.service.AccountService;

public class MockAccountService implements AccountService {

    private Bank bank;

    @Override
    public Integer add(Account account) {
        bank.getAccountMap().put(account.getId(), account);
        return null;
    }

    @Override
    public void deposit(int accountID, double amount) {
        bank.getAccountMap().get(accountID).credit(amount);
    }

    @Override
    public void withdraw(int accountID, double amount) {

        Account account = bank.getAccountMap().get(accountID);

        if (!account.canWithdraw()) {
            System.out.println(English.ERROR_CANT_WITHDRAW);
            return;
        }

        bank.getAccountMap().get(accountID).debit(amount);
    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

        Account srcAccount = bank.getAccountMap().get(srcId);
        Account dstAccount = bank.getAccountMap().get(dstId);

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }

    @Override
    public boolean accountExists(int accountID){
        return bank.getAccountMap().containsKey(accountID);
    }

    @Override
    public void addToCustomer(Integer accId, Integer customerId) {

    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
