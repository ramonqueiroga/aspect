package com.example.aspect.repository;

import com.example.aspect.Entity.BilheteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilheteRepository extends CrudRepository<BilheteEntity, Integer> {

}
