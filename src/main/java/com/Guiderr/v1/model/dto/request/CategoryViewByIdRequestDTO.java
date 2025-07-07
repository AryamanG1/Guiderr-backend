package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotNull;

public class CategoryViewByIdRequestDTO {
    @NotNull(message = "Category ID is required")
    private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
}
