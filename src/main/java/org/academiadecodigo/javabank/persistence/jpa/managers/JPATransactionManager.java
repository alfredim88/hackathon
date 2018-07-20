package org.academiadecodigo.javabank.persistence.jpa.managers;

import org.academiadecodigo.javabank.persistence.SessionManager;
import org.academiadecodigo.javabank.persistence.TransactionManager;

public class JPATransactionManager implements TransactionManager {

    private SessionManager sm;

    public JPATransactionManager(SessionManager sm) {
        this.sm = sm;
    }

    @Override
    public void beginRead() {
        sm.startSession();
    }

    @Override
    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    @Override
    public void commit() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().commit();
        }
        sm.stopSession();
    }

    @Override
    public void rollback() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().rollback();
        }
        sm.stopSession();
    }
}
