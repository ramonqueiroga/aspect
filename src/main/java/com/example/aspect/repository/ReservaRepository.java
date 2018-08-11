package com.example.aspect.repository;

import com.example.aspect.Entity.ReservaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends CrudRepository<ReservaEntity, Integer> {

}
