package com.promineotech.trainers.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.promineotech.trainers.entity.Workouts;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class BasicWorkoutDao implements WorkoutDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	@Override
	public List<Workouts> fetchWorkouts() {
		
		
		// @formatter:off
				String sql = ""
					+ "SELECT * "
					+ "FROM Workouts";
		// @formatter:on
				
				
			return jdbcTemplate.query(sql,
					new RowMapper<>() {

						@Override
						public Workouts mapRow(ResultSet rs, int rowNum) throws SQLException {
							//// @formatter:off
		 

							return Workouts.builder()
								.workoutId(rs.getLong("workout_id"))
								.workout(rs.getString("workout"))
								.build();
							// @formatter:on

						}});}
				
	@Override
	public Optional<Workouts> createWorkout(String workout) {
		log.info("DAO: workout = {}", workout);
		
		 //@formatter:off
	    String sql = ""
	        + "INSERT INTO Workouts ( "
	        + "workout "
	        + ") VALUES ( "
	        + ":workout)";
	     //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("workout", workout);
	    	    
	    jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Workouts.builder().workout(workout).build());
	}
	

	@Override
	public Optional<Workouts> updateWorkout(String workout, String newWorkout) {
		log.info("DAO: workout={} newWorkout = {}", workout, newWorkout);
		
		 //@formatter:off
		  String sql = ""
		      + "UPDATE Workouts SET "
		      + "workout =  :newWorkout "
		      + "WHERE workout = :workout";
		
		  
		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("workout", workout);
		  params.put("newWorkout", newWorkout);
		 
		  
		  jdbcTemplate.update(sql, params);
		  return Optional.ofNullable(Workouts.builder().workout(newWorkout).build());

	}

	@Override
	public Optional<Workouts> deleteWorkout(Long workoutId, String workout) {

		//@formatter:off
		  String sql = ""
		      + "DELETE FROM Workouts WHERE "
		      + "workout_id = :workout_id AND "
		      + "workout = :workout";
		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("workout_id", workoutId);
		  params.put("workout", workout);

		  jdbcTemplate.update(sql, params); 
		 
		  return Optional.ofNullable(Workouts.builder().workoutId(workoutId).workout(workout).build());
		
	}

}
