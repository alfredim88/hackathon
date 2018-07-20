package org.academiadecodigo.javabank.persistence.jpa.dao;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.AccountDao;
import org.academiadecodigo.javabank.persistence.SessionManager;

public class JPAAccountDao extends JPAGenericDao<Account> implements AccountDao {

    public JPAAccountDao() {
        super(Account.class);
    }
}
