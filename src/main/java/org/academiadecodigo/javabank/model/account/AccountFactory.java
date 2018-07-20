package org.academiadecodigo.javabank.model.account;

public class AccountFactory {

    public static int numberAccounts;

    public static Account createAccount(AccountType type){

        Account newAccount;
        numberAccounts++;

        if (type == AccountType.CHECKING) {
            newAccount = new CheckingAccount();

        } else {
            newAccount = new SavingsAccount();
        }

        return newAccount;
    }
}
