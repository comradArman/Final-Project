package com.promineotech.trainers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.trainers.TrainerWorkouts;
import com.promineotech.trainers.entity.Trainer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping ("/trainers")
@OpenAPIDefinition(info = @Info(title = "Trainer Workouts"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})






public interface TrainersController {
	//@formatter:off
		@Operation(
			summary = "Create a Trainer",
			description = "Returns a Trainer",
			responses = {
				@ApiResponse(
						responseCode = "201", 
						description = "The Trainer is returned", 
						content = @Content(mediaType = "application/json", 
						schema = @Schema(implementation = Trainer.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "No Trainers were found with the input criteria",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occurred.",
						content = @Content(mediaType = "application/json"))
						
			},
			parameters = {
					@Parameter(
							name = "name",
							required = true, 
							description = "The Trainer's first name"),
				
			}
		)
		
		 // Post method (Create)
		  @PostMapping
		  @ResponseStatus(code = HttpStatus.CREATED)
		  Optional<Trainer> createTrainer(
		     @RequestParam(required = false) 
		     String name);
		
		
		
		@Operation(
			      summary = "Update a Trainer",
			      description = "Update a Trainer using the Trainers name",
			      responses = {
			          @ApiResponse(
			              responseCode = "200", 
			              description = "Trainer Updated!", 
			              content = @Content(
			                  mediaType = "application/json", 
			              schema = @Schema(implementation = Trainer.class))),
			          @ApiResponse(
			              responseCode = "400", 
			              description = "The request parameters are invalid.", 
			              content = @Content(
			                  mediaType = "application/json")),
			          @ApiResponse(
			              responseCode = "404", 
			              description = "Unable to update the Trainer", 
			              content = @Content(
			                  mediaType = "application/json")),
			          @ApiResponse(
			              responseCode = "500", 
			              description = "An unplanned error occurred.", 
			              content = @Content(
			                  mediaType = "application/json"))
			      },
			      
			          
			       parameters = {
			          @Parameter(
			              name = "name",
			              allowEmptyValue = false,
			              required = false,
			              description = "The Trainer's first name")
			        
			      }
			  )
			  
			  // Put method (Update)
			 @PutMapping
			 @ResponseStatus(code = HttpStatus.OK)
			 Optional<Trainer> updateTrainer(			  
			     @RequestParam(required = false)
			     String name,
			     @RequestParam(required = false)
		         String newName);
			    
		   
	

	
	@Operation(
	    summary = "Returns a list of Trainers",
	    description = "Returns a list",
	    responses = {
	        @ApiResponse(
	            responseCode = "200", 
	            description = "A list of Trainers is returned.", 
	            content = @Content(
	                mediaType = "application/json", 
	            schema = @Schema(implementation = Trainer.class))),
	        @ApiResponse(
	            responseCode = "400", 
	            description = "The request parameters are invalid.", 
	            content = @Content(
	                mediaType = "application/json")),
	        @ApiResponse(
	            responseCode = "404", 
	            description = "No Trainers were found with the input criteria.", 
	            content = @Content(
	                mediaType = "application/json")),
	        @ApiResponse(
	            responseCode = "500", 
	            description = "An unplanned error occurred.", 
	            content = @Content(
	                mediaType = "application/json"))
	    
	  
	   
	    }
	    )
	  //Get method (Read) 
	  @GetMapping
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Trainer> fetchTrainers();
	    
	
	 @Operation(
		     summary = "Deletes a Trainer" ,
		     description = "Delete a Trainer given a required TrainerId and name",
		     responses = {
		         @ApiResponse(
		             responseCode = "200", 
		             description = "A Trainer is deleted.", 
		             content = @Content(
		                 mediaType = "application/json", 
		             schema = @Schema(implementation = TrainerWorkouts.class))),
		         @ApiResponse(
		             responseCode = "400", 
		             description = "The request parameters are invalid.", 
		             content = @Content(
		                 mediaType = "application/json")),
		         @ApiResponse(
		             responseCode = "404", 
		             description = "No Trainers were found with the input criteria.", 
		             content = @Content(
		                 mediaType = "application/json")),
		         @ApiResponse(
		             responseCode = "500", 
		             description = "An unplanned error occurred.", 
		             content = @Content(
		                 mediaType = "application/json"))
		     },
		     parameters = {
		         @Parameter(
		             name = "trainerId", 
		             allowEmptyValue = false, 
		             required = false, 
		             description = "The Trainer's ID"), 
		         @Parameter(
		             name = "name",
		             allowEmptyValue = false,
		             required = false,
		             description = "The Trainer's first name")
		     
		     }
	   )
	 // Delete method (Delete)
	  @DeleteMapping
	  @ResponseStatus(code = HttpStatus.OK)
	  Optional<Trainer> deleteTrainers(
	      @RequestParam(required = false) 
	      Long trainerId,
	      @RequestParam(required = false)
	      String name);
	  
	 
	 
	 @Operation(
			    summary = "Returns a list of Trainers",
			    description = "Returns a list",
			    responses = {
			        @ApiResponse(
			            responseCode = "200", 
			            description = "A list of Trainers is returned.", 
			            content = @Content(
			                mediaType = "application/json", 
			            schema = @Schema(implementation = Trainer.class))),
			        @ApiResponse(
			            responseCode = "400", 
			            description = "The request parameters are invalid.", 
			            content = @Content(
			                mediaType = "application/json")),
			        @ApiResponse(
			            responseCode = "404", 
			            description = "No Trainers were found with the input criteria.", 
			            content = @Content(
			                mediaType = "application/json")),
			        @ApiResponse(
			            responseCode = "500", 
			            description = "An unplanned error occurred.", 
			            content = @Content(
			                mediaType = "application/json"))
			    },
			        parameters = {
					         @Parameter(
					             name = "trainerId", 
					             allowEmptyValue = false, 
					             required = false, 
					             description = "The Trainer's ID")
			    
			  
			           
			    }
			  )  
			  //Get method (Read) 
			  @GetMapping("/trainer_workout_by_Id")
			  @ResponseStatus(code = HttpStatus.OK)
			  List<Trainer> fetchTrainerIdWorkout(Long trainerId);
			    
	 
	 //@formatter:on

	 
	}

