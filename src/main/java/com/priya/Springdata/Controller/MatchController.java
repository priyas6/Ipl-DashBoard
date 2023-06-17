package com.priya.Springdata.Controller;
import com.priya.Springdata.Model.*;
import com.priya.Springdata.Repository.MatchRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class MatchController {
	@Autowired
    private MatchRepository matchRepository;

@GetMapping("/team/{teamName}/matches")
public List<Match> getMatches(@PathVariable String teamName,@RequestParam int year)
{
	LocalDate startDate=LocalDate.of(year, 1, 1);
	LocalDate endDate=LocalDate.of(year+1, 1, 1);
	return matchRepository.findMatchesByYear(teamName,startDate,endDate);
}
	
}
