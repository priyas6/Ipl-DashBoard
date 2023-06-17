package com.priya.Springdata.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	public Team() {
		super();
	}
	private String teamName;
	public Team(String teamName, long totalMatches) {
		super();
		this.teamName = teamName;
		this.totalMatches = totalMatches;
	}
	private long totalMatches;
	private long totalWins;
	@Transient
	private List<Match> matches;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public long getTotalMatches() {
		return totalMatches;
	}
	public void setTotalMatches(long totalMatches) {
		this.totalMatches = totalMatches;
	}
	public long getTotalWins() {
		return totalWins;
	}
	public void setTotalWins(long totalWins) {
		this.totalWins = totalWins;
	}
	public List<Match> getMatches() {
		return matches;
	}
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	
	

}
