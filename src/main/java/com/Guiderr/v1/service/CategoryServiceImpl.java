package com.Guiderr.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.Guiderr.v1.mapper.CategoryMapper;
import com.Guiderr.v1.model.Category;
import com.Guiderr.v1.model.dto.request.*;
import com.Guiderr.v1.model.dto.response.CategoryResponseDTO;
import com.Guiderr.v1.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryCreateRequestDTO request) {
        logger.trace("Entering createCategory()");
        Category category = categoryMapper.toEntity(request);
        logger.debug("Mapped request to entity: {}", category.getName());
        categoryRepository.save(category);
        logger.trace("Exiting createCategory()");
        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO deleteCategory(CategoryDeleteRequestDTO request) {
        logger.trace("Entering deleteCategory() with ID: {}", request.getID());
        Category category = categoryRepository.findById(request.getID()).orElseThrow(() -> {
            logger.error("Could not find category with ID: {}", request.getID());
            return new RuntimeException("Could not find category with ID");
        });
        logger.debug("Deleting category: {}", category.getName());
        categoryRepository.delete(category);
        logger.trace("Exiting deleteCategory()");
        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(CategoryUpdateRequestDTO request) {
        logger.trace("Entering updateCategory() with ID: {}", request.getId());
        Category category = categoryRepository.findById(request.getId()).orElseThrow(() -> {
            logger.error("Could not find category with ID: {}", request.getId());
            return new RuntimeException("Could not find category with ID");
        });

        Category parent = null;
        if (request.getParentId() != null) {
            parent = categoryRepository.findById(request.getParentId()).orElseThrow(() -> {
                logger.error("Invalid parent category ID: {}", request.getParentId());
                return new RuntimeException("Parent Category ID is invalid");
            });
            logger.debug("Found parent category: {}", parent.getName());
        }

        categoryMapper.updateCategory(category, request, parent);
        logger.debug("Updated category: {}", category.getName());
        categoryRepository.save(category);
        logger.trace("Exiting updateCategory()");
        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> viewAllCategories() {
        logger.trace("Entering viewAllCategories()");
        List<Category> categories = categoryRepository.findAll();
        logger.debug("Fetched {} categories", categories.size());
        List<CategoryResponseDTO> response = categories.stream()
            .map(categoryMapper::toResponseDTO)
            .collect(Collectors.toList());
        logger.trace("Exiting viewAllCategories()");
        return response;
    }

    @Override
    public CategoryResponseDTO viewCategoryById(CategoryViewByIdRequestDTO request) {
        logger.trace("Entering viewCategoryById() with ID: {}", request.getId());
        Category category = categoryRepository.findById(request.getId()).orElseThrow(() -> {
            logger.error("Invalid category ID: {}", request.getId());
            return new RuntimeException("Category ID is invalid");
        });
        logger.debug("Found category: {}", category.getName());
        logger.trace("Exiting viewCategoryById()");
        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> viewCategoryByName(CategoryViewByNameRequestDTO request) {
        logger.trace("Entering viewCategoryByName() with name: {}", request.getName());
        List<Category> categories = categoryRepository.findByNameContaining(request.getName());
        logger.debug("Found {} categories matching name: {}", categories.size(), request.getName());
        List<CategoryResponseDTO> response = categories.stream()
            .map(categoryMapper::toResponseDTO)
            .collect(Collectors.toList());
        logger.trace("Exiting viewCategoryByName()");
        return response;
    }
}
