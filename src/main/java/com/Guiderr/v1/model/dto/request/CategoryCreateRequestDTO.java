package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CategoryCreateRequestDTO {
	@NotBlank(message = "Category name is required")
    private String name;

    private Long parentId;// Optional parent category

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
