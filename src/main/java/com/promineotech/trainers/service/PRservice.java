package com.promineotech.trainers.service;

import java.util.List;
import java.util.Optional;

import com.promineotech.trainers.entity.PersonalRecords;

public interface PRservice {

	 /**
	   * 
	   * @param weight
	   * @param reps
	   * @return
	   */


	 Optional<PersonalRecords> createPR(int weight, int reps);
	 
	 List<PersonalRecords> fetchPR();
	 
	 Optional<PersonalRecords> updatePR(int weight, int reps, int newWeight, int newReps);
	 
	 Optional<PersonalRecords> deletePR(int weight, int reps);
	 
	 
	 
	
	 
		
	
}
