package com.prospecta.model;

import java.util.*;

public class ApiResponse {
    private int count;
    private List<ApiEntry> entries;
    
	public ApiResponse(int count, List<ApiEntry> entries) {
		super();
		this.count = count;
		this.entries = entries;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<ApiEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<ApiEntry> entries) {
		this.entries = entries;
	}
    
	
    
}
