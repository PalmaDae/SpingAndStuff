package com.example.springstuff.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    void save(T t);
    Optional<T> getById(ID id);
    List<T> getAll();
    void update(T t);
    boolean deleteById(ID id);
    void deleteAll();
}