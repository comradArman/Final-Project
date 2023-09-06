package com.promineotech.trainers;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class TrainerWorkouts {

	public static void main(String[] args) {
		
		SpringApplication.run(TrainerWorkouts.class, args);
		

	}

}
