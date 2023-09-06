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
import com.promineotech.trainers.entity.Workouts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping ("/Workouts")
@OpenAPIDefinition(info = @Info(title = "Workouts"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})





public interface WorkoutController {
	
	
	//@formatter:off
			@Operation(
				summary = "Create a Workout",
				description = "Returns the Workout",
				responses = {
					@ApiResponse(
							responseCode = "201", 
							description = "The name of the workout", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = Workouts.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No Workouts were found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred.",
							content = @Content(mediaType = "application/json"))
							
				},
				parameters = {
						@Parameter(
								name = "workout",
								required = true, 
								description = "The name of the Workout"),
					
				}
			)
			
			 // Post method (Create)
			  @PostMapping
			  @ResponseStatus(code = HttpStatus.CREATED)
			  Optional<Workouts> createWorkout(
			     @RequestParam(required = false) 
			     String workout);
			
			
			
			@Operation(
				      summary = "Updates a Workout",
				      description = "Update a Workout using the name",
				      responses = {
				          @ApiResponse(
				              responseCode = "200", 
				              description = "Workout Updated!", 
				              content = @Content(
				                  mediaType = "application/json", 
				              schema = @Schema(implementation = Workouts.class))),
				          @ApiResponse(
				              responseCode = "400", 
				              description = "The request parameters are invalid.", 
				              content = @Content(
				                  mediaType = "application/json")),
				          @ApiResponse(
				              responseCode = "404", 
				              description = "Unable to update the Workout", 
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
				              name = "workout",
				              allowEmptyValue = false,
				              required = false,
				              description = "The name of the Workout")
				        
				      }
				  )
				  
				  // Put method (Update)
				 @PutMapping
				 @ResponseStatus(code = HttpStatus.OK)
				 Optional<Workouts> updateWorkout(			  
				     @RequestParam(required = false)
				     String workout,
					 @RequestParam(required = false)
					 String newWorkout);
			
			
			
				    
			
			@Operation(
				    summary = "Returns a list of Workouts",
				    description = "list of Workouts",
				    responses = {
				        @ApiResponse(
				            responseCode = "200", 
				            description = "A list of Workouts are returned.", 
				            content = @Content(
				                mediaType = "application/json", 
				            schema = @Schema(implementation = Workouts.class))),
				        @ApiResponse(
				            responseCode = "400", 
				            description = "The request parameters are invalid.", 
				            content = @Content(
				                mediaType = "application/json")),
				        @ApiResponse(
				            responseCode = "404", 
				            description = "No Workouts were found with the input criteria.", 
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
			  List<Workouts> fetchWorkouts();
			
			
			
			@Operation(
				     summary = "Deletes a Workout" ,
				     description = "Delete a Workout given a required WorkoutId and name of Workout",
				     responses = {
				         @ApiResponse(
				             responseCode = "200", 
				             description = "The Workout is deleted.", 
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
				             name = "workoutId", 
				             allowEmptyValue = false, 
				             required = false, 
				             description = "The Workout's ID"), 
				         @Parameter(
				             name = "workout",
				             allowEmptyValue = false,
				             required = false,
				             description = "The name of the Workout")
				     
				     }
			   )
			 // Delete method (Delete)
			  @DeleteMapping
			  @ResponseStatus(code = HttpStatus.OK)
			  Optional<Workouts> deleteWorkout(
			      @RequestParam(required = false) 
			      Long workoutId,
			      @RequestParam(required = false)
			      String workout);
			  
			  //@formatter:on
			
			
			
	
	
	
	
	
	
}
