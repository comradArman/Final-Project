package com.promineotech.trainers.service;

import java.util.List;
import java.util.Optional;

import com.promineotech.trainers.entity.Workouts;

public interface WorkoutService {
	
	 /**
	   * 
	   * @param WorkoutID
	   * @param Workout
	   * @return
	   */


	 Optional<Workouts> createWorkout(String workout);
	 
	 List<Workouts> fetchWorkouts();
	 
	 Optional<Workouts> updateWorkout(String workout, String newWorkout);
	 
	 Optional<Workouts> deleteWorkout(Long workoutId, String workout);
	 
	 
	 
	
	 
		
	}


