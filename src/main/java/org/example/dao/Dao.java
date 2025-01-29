package org.example.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface Dao<T> {
    T getById(long id);

    List<T> getAll();

    T save(T t);

    T update(T t, String params);

    String delete(long T);
}
