package com.priya.Springdata.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.priya.Springdata.Model.Team;
import com.priya.Springdata.Repository.MatchRepository;
import com.priya.Springdata.Repository.TeamRepository;
@RestController
@CrossOrigin("http://localhost:3000")
public class TeamController 
{
	@Autowired
    private MatchRepository matchRepository;
	@Autowired
	private TeamRepository teamRepository;
	@GetMapping("/teams")
	public Iterable <Team> getAllTeams()
	{
		return teamRepository.findAll();
	}
    @GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String  teamName )
	{
    	Team team=teamRepository.findByTeamName(teamName);
    	team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));
		return team;
	}

}
