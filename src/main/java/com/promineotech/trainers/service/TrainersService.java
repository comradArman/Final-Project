package com.promineotech.trainers.service;

import java.util.List;
import java.util.Optional;

import com.promineotech.trainers.entity.Trainer;

public interface TrainersService {
	
	 /**
	   * 
	   * @param TrainerId
	   * @param name
	   * @return
	   */

	Optional<Trainer> createTrainer(String name);
	
	List<Trainer> fetchTrainers();

	Optional<Trainer> deleteTrainer(Long trainerId, String name);

	Optional<Trainer> updateTrainer(String name, String newName);

	List<Trainer> fetchTrainerIdWorkout(Long trainerId);
		
		
	
		
		
	}


