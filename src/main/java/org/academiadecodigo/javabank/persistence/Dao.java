package org.academiadecodigo.javabank.persistence;

import java.util.List;

public interface Dao<T> {

    T findById(Integer id);
    List<T> findAll();
    T saveOrUpdate(T entity);
    void delete(Integer id);
}
