package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotNull;

public class CategoryUpdateRequestDTO {
	@NotNull(message = "Category ID is required")
    private Long id;

    private String name;

    private Long parentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
    
    
}
