package com.promineotech.trainers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PersonalRecords {
	
	private Long prId;
	private Long workoutId;
	private int weight;
	private int reps;

}
