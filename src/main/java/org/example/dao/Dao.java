package org.example.dao;

import java.util.List;

public interface Dao<T> {
    T getById(long id);

    List<T> getAll();

    T save(T t);

    T update(T t, String params);

    String delete(T t);
}
