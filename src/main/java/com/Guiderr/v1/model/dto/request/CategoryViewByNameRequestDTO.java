package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CategoryViewByNameRequestDTO {
	@NotBlank(message = "Category name is required")
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
