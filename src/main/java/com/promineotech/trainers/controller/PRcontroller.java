package com.promineotech.trainers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.trainers.entity.PersonalRecords;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface PRcontroller {
	//@formatter:off
	@Operation(
		summary = "Create a Personal Record",
		description = "Returns the Personal Record",
		responses = {
			@ApiResponse(
					responseCode = "201", 
					description = "The Personal Record is returned", 
					content = @Content(mediaType = "application/json", 
					schema = @Schema(implementation = PersonalRecords.class))),
			@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid",
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404", 
					description = "No Personal Records were found with the input criteria",
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occurred.",
					content = @Content(mediaType = "application/json"))
					
		},
		parameters = {
				@Parameter(
						name = "weight",
						required = true, 
						description = "The weight of the personal record"),
				@Parameter(
						name = "reps",
						required = true, 
						description = "The number of reps for the personal record"),
				
			
		}
	)
	
	 // Post method (Create)
	  @PostMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  Optional<PersonalRecords> createPR(
	     @RequestParam(required = false) 
	     int weight,
		 @RequestParam(required = false) 
		 int reps);
	
	@Operation(
			summary = "Update a Personal Record",
			description = "Update a Personal Record using a required Weight and Reps",
			responses = {
				@ApiResponse(
						responseCode = "201", 
						description = "The Personal Record is updated", 
						content = @Content(mediaType = "application/json", 
						schema = @Schema(implementation = PersonalRecords.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "unable to update with the input criteria",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occurred.",
						content = @Content(mediaType = "application/json"))
						
			},
			parameters = {
					@Parameter(
							name = "weight",
							required = true, 
							description = "The weight of the personal record"),
					@Parameter(
							name = "reps",
							required = true, 
							description = "The number of reps for the personal record")
				
			}
		)
		
		 
		  @PutMapping
		  @ResponseStatus(code = HttpStatus.OK)
		  Optional<PersonalRecords> updatePR(
		     @RequestParam(required = false) 
		     int weight,
			 @RequestParam(required = false) 
			 int reps,
			 @RequestParam(required = false) 
		     int newWeight,
			 @RequestParam(required = false) 
			 int newReps);
	
	
	@Operation(
			summary = "Returns a list of Personal Records",
			description = "Fetchs a list of Personal Records",
			responses = {
				@ApiResponse(
						responseCode = "201", 
						description = "The list of Personal Records as been returned", 
						content = @Content(mediaType = "application/json", 
						schema = @Schema(implementation = PersonalRecords.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "unable to reach the list of Personal Records",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occurred.",
						content = @Content(mediaType = "application/json"))
						
		
				
			}
		)
		
		 
		  @GetMapping
		  @ResponseStatus(code = HttpStatus.OK)
		  List<PersonalRecords> fetchPR();
	
	
	@Operation(
		     summary = "Deletes a Personal Record",
		     description = "Delete a Personal Record given a required weight and Number of reps",
		     responses = {
		         @ApiResponse(
		             responseCode = "200", 
		             description = "A Personal Record is deleted.", 
		             content = @Content(
		                 mediaType = "application/json", 
		             schema = @Schema(implementation = PersonalRecords.class))),
		         @ApiResponse(
		             responseCode = "400", 
		             description = "The request parameters are invalid.", 
		             content = @Content(
		                 mediaType = "application/json")),
		         @ApiResponse(
		             responseCode = "404", 
		             description = "No Personal Records were found with the input criteria.", 
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
		             name = "weight", 
		             allowEmptyValue = false, 
		             required = false, 
		             description = "How much weight"), 
		         @Parameter(
		             name = "reps",
		             allowEmptyValue = false,
		             required = false,
		             description = "The number of Reps") 
		     }
		 )
		  // Delete method (Delete)
		  @DeleteMapping
		  @ResponseStatus(code = HttpStatus.OK)
		  Optional<PersonalRecords> deletePR(
		      @RequestParam(required = false) 
		      int weight,
		      @RequestParam(required = false)
		      int reps);
		  
		  //@formatter:on
		    
		
}