package com.promineotech.trainers.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.trainers.entity.Workouts;

public interface WorkoutDao {
	
	
	  List<Workouts> fetchWorkouts();

	  
	  /**
	   * 
	   * @param workout
	   * @return
	   */
	  Optional<Workouts> createWorkout(String workout);
	  
	 
	  /**
	   * 
	   * @param workout
	   * @return
	   */
	  Optional<Workouts> updateWorkout(String workout, String newWorkout);

	  /**
	   * 
	   * @param workoutId
	   * @param workout
	   * @return
	   */
	  Optional<Workouts> deleteWorkout(Long workoutId, String workout);
	  
	}


