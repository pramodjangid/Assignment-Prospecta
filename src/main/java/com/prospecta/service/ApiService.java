package com.prospecta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.model.ApiEntry;
import com.prospecta.model.ApiResponse;
import com.prospecta.repository.ApiRepository;

@Service
public class ApiService {
	
	@Autowired
	private ApiRepository apiRepository;
	
    private final String apiUrl = "https://api.publicapis.org";

    public List<ApiEntry> getApiEntries() {
        RestTemplate restTemplate = new RestTemplate();
        ApiResponse receivedResponse = restTemplate.getForObject(apiUrl, ApiResponse.class);
        
         return receivedResponse.getEntries();
    }
    
    
    public ApiEntry saveNewEntry(ApiEntry newApiEntry) {
    	
    	// check for duplicate entries using id field or any desired field.
    	Optional<ApiEntry> optional = apiRepository.findById(newApiEntry.getId());
    	
    	if(!optional.isPresent()) {
    		apiRepository.save(newApiEntry);
    	}
    	else {
    		throw new DataIntegrityViolationException("This Entry is already present");
    	}
    	
    	return optional.get();
    	
    }
}
