package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotNull;

public class CategoryDeleteRequestDTO {

	@NotNull(message ="ID field cannot be empty")
	private Long id;

	public Long getID() {
		return id;
	}

	public void setID(Long iD) {
		id = iD;
	}
	
	
}
