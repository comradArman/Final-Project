package com.promineotech.trainers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.trainers.entity.PersonalRecords;
import com.promineotech.trainers.service.PRservice;
import lombok.extern.slf4j.Slf4j;

@RestController 
@Slf4j
public class BasicPRController implements PRcontroller {

	@Autowired
	private PRservice pRService;
	
	@Override
	public Optional<PersonalRecords> createPR(int weight, int reps) {
		log.info("weight = {}, reps = {}", weight, reps);
		return pRService.createPR(weight, reps);
	}
	
	@Override
	  public List<PersonalRecords> fetchPR() {
	    log.info("The fetchPR method was called"); 
	    
	    return pRService.fetchPR(); 
	  }
	
	@Override
	public  Optional<PersonalRecords> deletePR(int weight, int reps) {
		log.info("weight={}, reps={}", weight, reps);
		
		return pRService.deletePR(weight,reps);
		
		
	}
	
	@Override
	 public Optional<PersonalRecords> updatePR(int weight, int reps, int newWeight, int newReps) {
	    log.info("weight={}, reps={}", weight, reps); 
	    
	   return pRService.updatePR(weight,reps, newWeight, newReps); 
	  }


	
}
	