package com.promineotech.trainers.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.trainers.entity.PersonalRecords;

public interface PersonalRecordsDao {
	
	/**
	   * 
	   * @param weight
	   * @param reps
	   * @return
	   */

	Optional<PersonalRecords> createPR(int weight, int reps);
	
	List<PersonalRecords> fetchPR();
	
	/**
	   * 
	   * @param weight
	   * @param reps
	   * @param newWeight
	   * @param newReps
	   * @return
	   */

	Optional<PersonalRecords> updatePR(int weight, int reps, int newWeight, int newReps);
	
	/**
	   * 
	   * @param weight
	   * @param reps
	   * @return
	   */

	Optional<PersonalRecords> deletePR(int weight, int reps);



}
