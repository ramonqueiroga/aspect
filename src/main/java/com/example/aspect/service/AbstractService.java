package com.example.aspect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class AbstractService<E, I, R extends CrudRepository<E, I>> implements DefaultService<E, I> {

    @Autowired
    private R repository;

    @Override
    public E save(E entity) {
        return this.repository.save(entity);
    }

    @Override
    public void delete(E entity) {
        this.repository.delete(entity);
    }


    @Override
    public Optional<E> findOne(I id) {
        return this.repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return (List<E>)this.repository.findAll();
    }

}
