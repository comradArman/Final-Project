package com.promineotech.trainers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.trainers.dao.WorkoutDao;
import com.promineotech.trainers.entity.Workouts;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class BasicWorkoutService implements WorkoutService {
	
	
	@Autowired
	private WorkoutDao workoutDao;

	
	@Transactional(readOnly = true)
	@Override
	public List<Workouts> fetchWorkouts() {
		
		
		return workoutDao.fetchWorkouts();
	}
	
	 
	@Override
	public Optional<Workouts> updateWorkout(String workout, String newWorkout) {
		log.info("Workout name={}", workout);
		
		return workoutDao.updateWorkout(workout, newWorkout);
	}

	
	@Override
	public Optional<Workouts> createWorkout(String workout) {
		log.info("Workout name={}", workout);
		
		return workoutDao.createWorkout(workout);
	}


	
	@Override
	public Optional<Workouts> deleteWorkout(Long workoutId, String workout) {
		
		return workoutDao.deleteWorkout(workoutId, workout);
	}

	
}


