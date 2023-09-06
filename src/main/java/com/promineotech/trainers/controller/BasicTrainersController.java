package com.promineotech.trainers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.trainers.entity.Trainer;
import com.promineotech.trainers.service.TrainersService;

import lombok.extern.slf4j.Slf4j;

@RestController 
@Slf4j
public class BasicTrainersController implements TrainersController {

	@Autowired
	private TrainersService trainersService;
	
	@Override
	public Optional<Trainer> createTrainer(String name) {
		log.info("trainer={}", name);
		return trainersService.createTrainer(name);
	}
	
	@Override
	  public List<Trainer> fetchTrainers() {
	    log.info("List of Trainers fetched"); 
	    
	    return trainersService.fetchTrainers(); 
	  }
	
	@Override
	public  Optional<Trainer> deleteTrainers(Long trainerId, String name) {
		log.info("TrainerId={}", "Name = {}", trainerId, name);
		
		return trainersService.deleteTrainer(trainerId, name);
		
		
	}
	
	@Override
	 public Optional<Trainer> updateTrainer(String name, String newName) {
	    log.info("Name={}", name ); 
	    
	   return trainersService.updateTrainer(name, newName); 
	  }

	@Override
	public List<Trainer> fetchTrainerIdWorkout(Long trainerId) {
		log.info("TrainerId = {}", trainerId);
		
		return trainersService.fetchTrainerIdWorkout(trainerId); 
	}

	
	
	
	
	
}
	
	


