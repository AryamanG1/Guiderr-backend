package com.Guiderr.v1.model.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class StoreUpdateRequestDTO {
	private UUID ID;
    private String name;
    private String location;
    private Long length;
    private Long width;
    private int gridUnitSize = 1;
    
	public UUID getID() {
		return ID;
	}
	public void setID(UUID iD) {
		ID = iD;
	}
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
