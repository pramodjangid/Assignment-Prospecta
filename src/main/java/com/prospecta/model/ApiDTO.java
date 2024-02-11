package com.prospecta.model;



public class ApiDTO {
	
	private String API;
	
    private String Description;
	
    private String Category;
    
    
	public ApiDTO(String aPI, String description, String category) {
		super();
		API = aPI;
		Description = description;
		Category = category;
	}


	public String getAPI() {
		return API;
	}


	public void setAPI(String aPI) {
		API = aPI;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
	}
    
    
    
}
