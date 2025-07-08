package com.Guiderr.v1.model.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class StoreDeleteByIdRequestDTO {
	@NotNull(message="ID field cannot be emty")
	private UUID id;

	public UUID getID() {
		return id;
	}

	public void setID(UUID iD) {
		id = iD;
	}
	
	
}
