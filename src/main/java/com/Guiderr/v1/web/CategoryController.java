package com.Guiderr.v1.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Guiderr.v1.model.dto.request.CategoryCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.CategoryDeleteRequestDTO;
import com.Guiderr.v1.model.dto.request.CategoryUpdateRequestDTO;
import com.Guiderr.v1.model.dto.request.CategoryViewByIdRequestDTO;
import com.Guiderr.v1.model.dto.request.CategoryViewByNameRequestDTO;
import com.Guiderr.v1.model.dto.response.CategoryResponseDTO;
import com.Guiderr.v1.service.CategoryService;
import com.Guiderr.v1.utils.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}



	@PostMapping("/category/id")
	public ResponseEntity<ApiResponse<CategoryResponseDTO>> getCategoryByID(@RequestBody @Valid CategoryViewByIdRequestDTO request)
	{
		try{
			CategoryResponseDTO cat = categoryService.viewCategoryById(request);
			return ResponseEntity.ok(ApiResponse.success("Found Category by ID", cat));
		}
		catch(ResponseStatusException e) {
			return new ResponseEntity<>(ApiResponse.failure(e.getReason()),e.getStatusCode());
		}
	}
	
	@PostMapping("/category")
	public ResponseEntity<ApiResponse<CategoryResponseDTO>> createCategory(@RequestBody @Valid  CategoryCreateRequestDTO request)
	{
		try{
			CategoryResponseDTO cat = categoryService.createCategory(request);
			return ResponseEntity.ok(ApiResponse.success("Created Category", cat));
		}
		catch(ResponseStatusException e) {
			return new ResponseEntity<>(ApiResponse.failure(e.getReason()),e.getStatusCode());
		}
	}
	
	@PutMapping("/category")
	public ResponseEntity<ApiResponse<CategoryResponseDTO>> updateCategory(@RequestBody @Valid CategoryUpdateRequestDTO request)
	{
		try{
			CategoryResponseDTO cat = categoryService.updateCategory(request);
			return ResponseEntity.ok(ApiResponse.success("Updated Category", cat));
		}
		catch(ResponseStatusException e) {
			return new ResponseEntity<>(ApiResponse.failure(e.getReason()),e.getStatusCode());
		}
	}
	
	@DeleteMapping("/category")
	public ResponseEntity<ApiResponse<CategoryResponseDTO>> deleteCategory(@RequestBody @Valid CategoryDeleteRequestDTO request)
	{
		try{
			CategoryResponseDTO cat = categoryService.deleteCategory(request);
			return ResponseEntity.ok(ApiResponse.success("Deleted Category", cat));
		}
		catch(ResponseStatusException e) {
			return new ResponseEntity<>(ApiResponse.failure(e.getReason()),e.getStatusCode());
		}
	}
	
	@GetMapping("/categories")
	public ResponseEntity<ApiResponse<List<CategoryResponseDTO>>> getAllCategories()
	{
		try{
			List<CategoryResponseDTO> cat = categoryService.viewAllCategories();
			return ResponseEntity.ok(ApiResponse.success("All Categories", cat));
		}
		catch(ResponseStatusException e) {
			return new ResponseEntity<>(ApiResponse.failure(e.getReason()),e.getStatusCode());
		}
	}
	
	@PostMapping("/categories/name")
	public ResponseEntity<ApiResponse<List<CategoryResponseDTO>>> getCategoriesName(@RequestBody @Valid CategoryViewByNameRequestDTO request){
		try{
			List<CategoryResponseDTO> cat = categoryService.viewCategoryByName(request);
			return ResponseEntity.ok(ApiResponse.success("All Categories By Name", cat));
		}
		catch(ResponseStatusException e) {
			return new ResponseEntity<>(ApiResponse.failure(e.getReason()),e.getStatusCode());
		}
	}

	
	
}
