package com.Guiderr.v1.service;

import java.util.List;

import com.Guiderr.v1.model.dto.request.CategoryCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.CategoryDeleteRequestDTO;
import com.Guiderr.v1.model.dto.request.CategoryUpdateRequestDTO;
import com.Guiderr.v1.model.dto.request.CategoryViewByIdRequestDTO;
import com.Guiderr.v1.model.dto.request.CategoryViewByNameRequestDTO;
import com.Guiderr.v1.model.dto.response.CategoryResponseDTO;

public interface CategoryService {
	CategoryResponseDTO createCategory(CategoryCreateRequestDTO request);
	CategoryResponseDTO deleteCategory(CategoryDeleteRequestDTO request);
	CategoryResponseDTO updateCategory(CategoryUpdateRequestDTO request);
	List<CategoryResponseDTO> viewAllCategories();
	CategoryResponseDTO viewCategoryById(CategoryViewByIdRequestDTO request);
	List<CategoryResponseDTO> viewCategoryByName(CategoryViewByNameRequestDTO request);
}
