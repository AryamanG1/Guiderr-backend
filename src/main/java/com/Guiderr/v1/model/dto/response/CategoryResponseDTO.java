package com.Guiderr.v1.model.dto.response;

import java.util.List;

import lombok.Data;

public class CategoryResponseDTO {
	private Long id;
    private String name;

    private Long parentId;
    private String parentName;

    private List<SubCategoryDTO> subcategories;

    
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


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public List<SubCategoryDTO> getSubcategories() {
		return subcategories;
	}


	public void setSubcategories(List<SubCategoryDTO> subcategories) {
		this.subcategories = subcategories;
	}


	public static class SubCategoryDTO {
        private Long id;
        private String name;
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
    }
}
