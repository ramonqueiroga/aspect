package com.example.aspect.repository;

import com.example.aspect.Entity.SoccerTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoccerTeamRepository extends CrudRepository<SoccerTeam, Integer> {

}
