package com.Guiderr.v1.model.dto.request;

import java.util.UUID;
import jakarta.validation.constraints.NotNull;


public class ProductDeleteRequestDTO {
    @NotNull
    private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
    
}
