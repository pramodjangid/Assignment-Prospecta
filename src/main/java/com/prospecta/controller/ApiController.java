package com.prospecta.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import com.prospecta.model.*;

@RestController
public class ApiController {

//	  1) Create an API that lists the title, description based on the category passed as an input 
//	   parameter.
	
	
    private final String apiUrl = "https://api.publicapis.org/entries";
    
	@GetMapping("/api")
	public ResponseEntity<List<ApiDTO>> getDataByCategory(@RequestParam String category) {
		
		// Create an instance of Rest Template
		RestTemplate rt = new RestTemplate();
	    
		// Fetch data from the API endpoint
		ApiResponse recievedResponse = rt.getForObject(apiUrl, ApiResponse.class);
		
		if (recievedResponse != null) {
			
			// Get the list of entries from the response
			List<ApiEntry> entries = recievedResponse.getEntries();
			
			// Filter entries based on the provided category by stream API.
			List<ApiDTO> filteredEntries = entries.stream()
					.filter(entry -> category.equalsIgnoreCase(entry.getCategory()))
	                .map(entry -> new ApiDTO(entry.getAPI(), entry.getDescription(), entry.getCategory()))
	                .collect(Collectors.toList());
			
			return new ResponseEntity<>(filteredEntries, HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		
	}
    
  
}


    


