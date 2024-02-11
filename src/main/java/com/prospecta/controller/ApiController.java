package com.prospecta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import com.prospecta.model.*;
import com.prospecta.service.ApiService;

@RestController
public class ApiController {
	
	
	@Autowired
    private ApiService apiService;

	
//  1) Create an API that lists the title, description based on the category passed as an input parameter.
	
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
	
	
//	2) Create an API that would save a new entry with all the relevant properties which retrieves values 
//	   from the endpoint GET /entries.
	
    @PostMapping("/api/newentry")
    public ResponseEntity<String> saveNewEntry(@RequestBody ApiEntry newEntry) {
        apiService.saveNewEntry(newEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body("New entry saved successfully!");
    }
    
}



// 3)Question: what are the key things you would consider when creating/consuming an API 
//     to ensure that it is secure and reliable?

//   Answer: API is a crucial thing in web development. I always consider few things when i design an 
//       end point.
//    1. Control Access: Only let authorized users or programs use your API.

//    2. Validate Data: Check that the information going in is clean and won't cause problems.
//
//    3. Encrypt Traffic: Keep the data traveling between your API and users safe from prying eyes with encryption.
//
//    4. Limit Use: Prevent your API from being overwhelmed by controlling how much it's used.
//
//    5. Provide Clear Feedback: Explain clearly when something goes wrong so users can fix it easily.
//
//    6. Stay Flexible: Make your API easy to update without breaking existing stuff.
//
//    7. Monitor Performance: Keep an eye on how your API is doing to catch problems early.
//
//    8. Document Everything: Write down how your API works so people can use it without getting lost.




    


