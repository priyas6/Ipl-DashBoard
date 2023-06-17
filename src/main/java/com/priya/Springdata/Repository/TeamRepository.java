package com.priya.Springdata.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.priya.Springdata.Model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team,Integer> {
	
    Team findByTeamName(String teamName);
	}
