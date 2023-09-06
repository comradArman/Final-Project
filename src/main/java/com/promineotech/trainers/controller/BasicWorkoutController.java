package com.promineotech.trainers.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.trainers.entity.Workouts;
import com.promineotech.trainers.service.BasicWorkoutService;

import lombok.extern.slf4j.Slf4j;



@RestController 
@Slf4j
public class BasicWorkoutController implements WorkoutController {
	
	@Autowired
	private BasicWorkoutService workoutService;

	@Override
	public Optional<Workouts> createWorkout(String workout) {
		log.info("workout={}", workout);
		return workoutService.createWorkout(workout);
	}
	

	@Override
	public Optional<Workouts> updateWorkout(String workout, String newWorkout) {
	    log.info("workout={}, newWorkout={}", workout, newWorkout); 
	    
	   return workoutService.updateWorkout(workout, newWorkout); 
	  }
	

	@Override
	public List<Workouts> fetchWorkouts() {
		log.info("List of Trainers fetched"); 
		    
		  return workoutService.fetchWorkouts();
	}

	@Override
	public Optional<Workouts> deleteWorkout(Long workoutId, String workout) {
		
		log.info("TrainerId={}", "name = {}", workoutId, workout);
		
			return workoutService.deleteWorkout(workoutId, workout);
		
		
	}
		

}


