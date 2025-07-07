package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ProductsByNameRequestDTO {
	 @NotBlank
	    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
}
