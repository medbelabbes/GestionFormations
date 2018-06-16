package dao;

import java.util.List;

public interface IGenericDAO<T> {

    void create(T entity);
    void edit(T entity);
    void remove(T entity);
    T find(Object id);
    List<T> findAll();
    Long count();
}
