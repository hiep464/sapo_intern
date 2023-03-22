package com.sapo.edu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();

    T get(int id);

    void save(T t);

    void update(T t);

    void delete(T t);
}
