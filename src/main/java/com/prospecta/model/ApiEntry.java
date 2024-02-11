package com.prospecta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ApiEntry {
	@JsonIgnore
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonProperty("API")
    private String API;
	@JsonProperty("Description")
    private String Description;
	@JsonProperty("Auth")
    private String Auth;
	@JsonProperty("HTTPS")
    private boolean HTTPS;
	@JsonProperty("Cors")
    private String Cors;
	@JsonProperty("Link")
    private String Link;
	@JsonProperty("Category")
    private String Category;
	
	public ApiEntry(int id, String aPI, String description, String auth, boolean hTTPS, String cors, String link,
			String category) {
		super();
		this.id = id;
		API = aPI;
		Description = description;
		Auth = auth;
		HTTPS = hTTPS;
		Cors = cors;
		Link = link;
		Category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAuth() {
		return Auth;
	}
	public void setAuth(String auth) {
		Auth = auth;
	}
	public boolean isHTTPS() {
		return HTTPS;
	}
	public void setHTTPS(boolean hTTPS) {
		HTTPS = hTTPS;
	}
	public String getCors() {
		return Cors;
	}
	public void setCors(String cors) {
		Cors = cors;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
    
	

    
}
