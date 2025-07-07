package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class StoreCreateRequestDTO {

    @NotBlank(message = "Name of the store cannot be empty")
    private String name;

    @NotBlank(message = "Location of the store cannot be empty")
    private String location;

    @Min(value = 1, message = "Length must be a positive number")
    private Long length;

    @Min(value = 1, message = "Width must be a positive number")
    private Long width;

    @Min(value = 1, message = "Grid unit size must be at least 1")
    private int gridUnitSize = 1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Long getWidth() {
		return width;
	}

	public void setWidth(Long width) {
		this.width = width;
	}

	public int getGridUnitSize() {
		return gridUnitSize;
	}

	public void setGridUnitSize(int gridUnitSize) {
		this.gridUnitSize = gridUnitSize;
	}
    
}
