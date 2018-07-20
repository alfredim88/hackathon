package org.academiadecodigo.javabank.persistence.jpa.managers;

import org.academiadecodigo.javabank.persistence.SessionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


public class JPASessionManager implements SessionManager {

    @PersistenceUnit
    private EntityManagerFactory emf;
    private EntityManager em;

    public JPASessionManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void startSession() {
        if (this.em != null) {
            return;
        }

        this.em = emf.createEntityManager();
    }

    @Override
    public void stopSession() {
        if (em != null) {
            em.close();
        }

        em = null;
    }

    @Override
    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }
}
