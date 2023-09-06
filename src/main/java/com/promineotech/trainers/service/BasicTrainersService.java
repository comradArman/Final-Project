package com.promineotech.trainers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.trainers.dao.TrainersDao;
import com.promineotech.trainers.entity.Trainer;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class BasicTrainersService implements TrainersService {
	
	
	@Autowired
	private TrainersDao trainersDao;

	@Override
	public Optional<Trainer> createTrainer(String name) {
		log.info("The createTrainer method was called with first name = {}", name);
		return trainersDao.createTrainer(name);
		
		
	}
	
	@Transactional(readOnly = true)
	  @Override
	  public List<Trainer> fetchTrainers(){
	    log.info("The fetchTrainers method was called");
	    
	    return trainersDao.fetchTrainers();
	    
	}
	
	@Override
	  public Optional<Trainer> updateTrainer(String name, String newName) {
	   log.info("Name={}", name); 
	   
	   return trainersDao.updateTrainer(name, newName);
	 }
	
	@Override
	public Optional<Trainer> deleteTrainer(Long trainerId, String name)  {
	 
	  return trainersDao.deleteTrainer(trainerId, name); 
	}

	@Override
	public List<Trainer> fetchTrainerIdWorkout(Long trainerId) {
		log.info("The fetchTrainerIdWorkout method was called");
		return trainersDao. fetchTrainerIdWorkout(trainerId); 
	}
	
	
}
	  
