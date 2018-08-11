package com.example.aspect.service;

import java.util.List;
import java.util.Optional;

public interface DefaultService<E, I> {

    E save(E entity);
    void delete(E entity);
    Optional<E> findOne(I id);
    List<E> findAll();
}
