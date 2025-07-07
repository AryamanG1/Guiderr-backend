package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotNull;

public class CategoryDeleteRequestDTO {

	@NotNull(message ="ID field cannot be empty")
	private Long ID;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}
	
	
}
