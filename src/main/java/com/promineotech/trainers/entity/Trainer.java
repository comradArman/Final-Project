package com.promineotech.trainers.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Trainer {
	
	private Long trainerId;
	private String name;
	private Long workoutId;

	
	

}
