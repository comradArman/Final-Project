package com.promineotech.trainers.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.trainers.entity.Trainer;

public interface TrainersDao {
	
	
	/**
	   * 
	   * @param name
	   * @return
	   */
	Optional<Trainer> createTrainer(String name);
	
	
	List<Trainer> fetchTrainers();
	
	
	/**
	   * 
	   * @param name
	   * @return
	   */
	Optional<Trainer> updateTrainer(String name, String newName);
	
	
	/**
	   * 
	   * @param name
	   * @param trainerId
	   * @return
	   */
	Optional<Trainer> deleteTrainer(Long trainerId, String name);
		
	
	/**
	 * 
	 * @param trainerId
	 * @return
	 */

	List<Trainer> fetchTrainerIdWorkout(Long trainerId);

}
