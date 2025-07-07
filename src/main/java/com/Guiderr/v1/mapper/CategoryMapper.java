package com.Guiderr.v1.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.Guiderr.v1.model.Category;
import com.Guiderr.v1.model.dto.request.CategoryCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.CategoryUpdateRequestDTO;
import com.Guiderr.v1.model.dto.response.CategoryResponseDTO;
import com.Guiderr.v1.model.dto.response.CategoryResponseDTO.SubCategoryDTO;
import com.Guiderr.v1.repository.CategoryRepository;

@Component
public class CategoryMapper {
	
	private final CategoryRepository categoryRepository;
	
	

    public CategoryMapper(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}



	public CategoryResponseDTO toResponseDTO(Category category) {
        if (category == null) return null;

        CategoryResponseDTO response = new CategoryResponseDTO();
        response.setId(category.getID());
        response.setName(category.getName());

        // Safely handle null parent
        if (category.getParent() != null) {
            response.setParentId(category.getParent().getID());
            response.setParentName(category.getParent().getName());
        }

        // Set subcategories if they exist
        if (category.getSubcategories() != null && !category.getSubcategories().isEmpty()) {
            response.setSubcategories(
                category.getSubcategories()
                        .stream()
                        .map(this::toSubCategoryDTO) // ← FIXED: use method reference correctly
                        .collect(Collectors.toList())
            );
        }

        return response; 
    }
    
    

    public SubCategoryDTO toSubCategoryDTO(Category category) {
        if (category == null) return null;

        SubCategoryDTO dto = new SubCategoryDTO();
        dto.setId(category.getID());
        dto.setName(category.getName());
        return dto;
    }
    
    public Category toEntity(CategoryCreateRequestDTO request){
    	Category category = new Category();
    	if(request.getParentId()!=null){
    		Category parent = categoryRepository.findById(request.getParentId()).orElseThrow(() -> new RuntimeException("Parent ID not found"));
    		category.setParent(parent);
    	}
    	
    	category.setName(request.getName());
    	return category;
    }
    public void updateCategory(Category category, CategoryUpdateRequestDTO request, Category parentCategory) {
        if (request.getName() != null) {
            category.setName(request.getName());
        }

        // Set parent category if provided
        if (request.getParentId() != null) {
            category.setParent(parentCategory);
        } else {
            category.setParent(null); 
        }
    }}
