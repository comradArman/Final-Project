package com.promineotech.trainers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.trainers.dao.PersonalRecordsDao;
import com.promineotech.trainers.entity.PersonalRecords;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class BasicPRservice implements PRservice {
	
	@Autowired
	private PersonalRecordsDao personalRecordsDao;
	
	@Override
	public Optional<PersonalRecords> createPR(int weight, int reps) {
		log.info("weight={}, reps={}", weight, reps);
		return personalRecordsDao.createPR(weight, reps);
		
		
	}
	
	@Transactional(readOnly = true)
	  @Override
	  public List<PersonalRecords> fetchPR(){
	    log.info("The fetchPR method was called");
	    
	    return personalRecordsDao.fetchPR() ;
	    
	}
	
	@Override
	  public Optional<PersonalRecords> updatePR(int weight, int reps, int newWeight, int newReps) {
		log.info("weight={}, reps={}", weight, reps);
	   
	   return personalRecordsDao.updatePR(weight, reps, newWeight, newReps);
	 }
	
	@Override
	public Optional<PersonalRecords> deletePR(int weight, int reps)  {
		
	  return personalRecordsDao.deletePR(weight, reps); 
	}
	

}
