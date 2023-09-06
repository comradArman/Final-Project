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

import com.promineotech.trainers.entity.PersonalRecords;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicPersonalRecordsDao implements PersonalRecordsDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Optional<PersonalRecords> createPR(int weight, int reps) {
		log.info("DAO: weight = {}, reps = {}", weight, reps);
		
		 //@formatter:off
	    String sql = ""
	        + "INSERT INTO Personal_Records ("
	        + "weight, "
	        + "reps "
	        + ") VALUES ("
	        + ":weight, "
	        + ":reps)";
	     //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("weight", weight);
	    params.put("reps", reps);
	    	    
	    jdbcTemplate.update(sql, params);
		return Optional.ofNullable(PersonalRecords.builder().weight(weight).reps(reps).build());
		
	}

	@Override
	public List<PersonalRecords> fetchPR() {
		//@formatter:off
	    String sql = ""
	        + "Select * "
	     	+"FROM Personal_Records";
	     //@formatter:on
	    
	   
	 
		return jdbcTemplate.query(sql, 
				new RowMapper<>() {
			
			@Override
			public PersonalRecords mapRow(ResultSet rs, int rowNum) throws SQLException {
				//// @formatter:off


				return PersonalRecords.builder()
						.workoutId(rs.getLong("workout_id"))
						.weight(rs.getInt("weight"))
						.reps(rs.getInt("reps"))
						.build();
				// @formatter:on

			}});}
		
	

	@Override
	public Optional<PersonalRecords> updatePR(int weight, int reps, int newWeight, int newReps) {
		log.info("DAO: weight = {}, reps = {}, new weight = {}, new reps = {}", weight, reps, newWeight, newReps );
		  
		  //@formatter:off
		  String sql = ""
		      + "UPDATE Personal_Records SET "
		      + "weight = :newWeight, "
		      + "reps = :newReps "
		      + "WHERE weight = :weight "
		      + "AND "
		  	  + "reps = :reps ";
		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("weight", weight);
		  params.put("reps", reps);
		  params.put("newWeight", newWeight);
		  params.put("newReps", newReps);
		 
		
		  
		  jdbcTemplate.update(sql, params);
		  return Optional.ofNullable(PersonalRecords.builder().weight(newWeight).reps(newReps).build());
	
	}

	@Override
	public Optional<PersonalRecords> deletePR(int weight, int reps) {
		 //@formatter:off
		  String sql = ""
		      + "DELETE FROM Personal_Records WHERE"
		      + "weight = :weight AND"
		      + "reps = :reps";
		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("weight", weight);
		  params.put("reps", reps);

		  jdbcTemplate.update(sql, params); 
		  
		  return Optional.ofNullable(PersonalRecords.builder().weight(weight).reps(reps).build());
		
	}
	

	
	
}
