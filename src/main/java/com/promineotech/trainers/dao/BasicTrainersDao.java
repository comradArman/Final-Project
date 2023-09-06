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
import org.springframework.stereotype.Component;

import com.promineotech.trainers.entity.Trainer;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class BasicTrainersDao implements TrainersDao {
	
	
	@Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Optional<Trainer> createTrainer(String name) {
		log.info("DAO: Trainer's name = {}", name);
		
		 //@formatter:off
	    String sql = ""
	        + "INSERT INTO Trainers ("
	        + "name"
	        + ") VALUES ("
	        + ":name)";
	     //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("name", name);
	    	    
	    jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Trainer.builder().name(name).build());
	}

	@Override
	public List<Trainer> fetchTrainers() {
		 //@formatter:off
	    String sql = ""
	        + "Select * "
	     	+"FROM Trainers";
	     //@formatter:on
	    
	   
	   
		return jdbcTemplate.query(sql, 
				new RowMapper<>() {
			
			@Override
			public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
				//// @formatter:off


				return Trainer.builder()
						.trainerId(rs.getLong("trainers_id"))
						.name(rs.getString("name"))
						.build();
				// @formatter:on

			}});}
		
		
	@Override
	public Optional<Trainer> updateTrainer(String name, String newName) {
		log.info("DAO: name={}", name);
		
		 //@formatter:off
		  String sql = ""
		      + "UPDATE Trainers SET "
		      + "name=  :newName "
		      + "WHERE name = :name";
		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("name", name);
		  params.put("newName", newName);
		  
		  jdbcTemplate.update(sql, params);
		  return Optional.ofNullable(Trainer.builder().name(newName).build());
	}

	@Override
	public Optional<Trainer> deleteTrainer(Long trainerId, String name) {
		
		//@formatter:off
		  String sql = ""
		      + "DELETE FROM Trainers "
		      + "WHERE "
		      + "trainers_id = :trainerId AND "
		      + "name = :name";
		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("trainer_id", trainerId);
		  params.put("name", name);

		  jdbcTemplate.update(sql, params); 
		  
		  return Optional.ofNullable(Trainer.builder().trainerId(trainerId).name(name).build());
		
		
		
	}

	
		@Override
		  public List<Trainer> fetchTrainerIdWorkout(Long trainerId) {
		    log.info("DAO: fetchTrainerIdWorkout={}", trainerId);
		    
		    //@formatter:off
		    String sql = ""
		        + "SELECT * "
		        + "FROM Trainer_Workouts "
		        + "WHERE trainers_id = :trainers_id";
		    //@formatter:on
		    
		    Map<String, Object> params = new HashMap<>();
		    params.put("trainers_id", trainerId);
		   
		    
		    return jdbcTemplate.query(sql, params, new RowMapper<>() {

		 //Mapping every column name to corresponding instance variables within Pie table
		      @Override
		      public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
		        //@formatter:off
		        
		        		return Trainer.builder()
								.trainerId(rs.getLong("trainers_id"))
								.workoutId(rs.getLong("workout_id"))
								.build();
		        //@formatter:on
		      }});
	}

}
