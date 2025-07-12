package com.Guiderr.v1.model.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class GridRequestDTO {

	@NotNull(message="ID field cannot be emty")
	private UUID id;
	
	private String grid;
	
	

	public GridRequestDTO() {
		super();
	}

	public GridRequestDTO(@NotNull(message = "ID field cannot be emty") UUID id, String grid) {
		super();
		this.id = id;
		this.grid = grid;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getGrid() {
		return grid;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}
	
	

}
