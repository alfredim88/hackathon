package org.academiadecodigo.javabank.persistence.jpa.dao;


import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.persistence.Dao;
import org.academiadecodigo.javabank.persistence.SessionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

abstract class JPAGenericDao<T extends Model> implements Dao<T> {

    @PersistenceContext
    EntityManager em;
    private Class<T> modelType;


    JPAGenericDao(Class<T> modelType) {
        this.modelType = modelType;
    }


    @Override
    public List<T> findAll() {

        try {
            return em
                    .createQuery("from " + modelType
                            .getSimpleName(), modelType)
                    .getResultList();

        } catch (PersistenceException ex) {
            throw new PersistenceException(ex);
        }
    }

    @Override
    public T findById(Integer id) {

        try {
            return em.find(modelType, id);

        } catch (PersistenceException ex) {
            throw new PersistenceException(ex);
        }
    }

    @Override
    public T saveOrUpdate(T modelObject) {

        try {
            return em.merge(modelObject);

        } catch (PersistenceException ex) {
            throw new PersistenceException(ex);
        }
    }


    @Override
    public void delete(Integer id) {

        try {
        if (em.find(modelType, id) == null) {
            return;
        }
            em.remove(em.find(modelType, id));

        } catch (PersistenceException ex) {
            throw new PersistenceException(ex);
        }
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
