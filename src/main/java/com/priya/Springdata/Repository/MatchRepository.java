package com.priya.Springdata.Repository;
import com.priya.Springdata.Model.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MatchRepository extends CrudRepository <Match,Long>{
	List<Match> getByTeam1OrTeam2OrderByDateDesc(String TeamName1,String TeamName2,Pageable page);
	List<Match> getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(String teamName1,LocalDate date1,
			LocalDate date2,String TeamName2,LocalDate date3,LocalDate date4);
	
	default List<Match>findLatestMatchesByTeam(String teamName,int count)
	{
		return getByTeam1OrTeam2OrderByDateDesc(teamName,teamName,PageRequest.of(0, count));
	}
	default List<Match>findMatchesByYear(String teamName,LocalDate date1,LocalDate date2)
	{
		return getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(teamName,date1,date2,teamName,date1,date2);
	}
	
}
