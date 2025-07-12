package com.Guiderr.v1.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Store {
	
	@Id
	@GeneratedValue
	private UUID ID;
	
	@Column(nullable = false)
	@NotBlank(message="name of the store cannot be empty")
	private String name;
	
	@Column(nullable = false)
	@NotBlank(message = "location of the store cannot be empty")
	private String location;
	
	// The length of the store in meters
	private Long length;
	
	// The width of the store in meters
	private Long width;
	
	@Column(name = "grid_size")
	private int gridunitsize=1;
	
	@CreationTimestamp
	@Column(name="created_at",updatable=false)
	private Timestamp createdata;
	
	@Lob
	@Column(name="store_grid")
	private String grid;

	
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

	public int getGridunitsize() {
		return gridunitsize;
	}

	public void setGridunitsize(int gridunitsize) {
		this.gridunitsize = gridunitsize;
	}

	public Timestamp getCreatedata() {
		return createdata;
	}

	public void setCreatedata(Timestamp createdata) {
		this.createdata = createdata;
	}

	public String getGrid() {
		return grid;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}
	
	
	
}
