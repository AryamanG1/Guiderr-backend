package com.Guiderr.v1.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Guiderr.v1.model.Product;
import com.Guiderr.v1.model.dto.request.ProductCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductUpdateRequestDTO;
import com.Guiderr.v1.model.dto.response.ProductResponseDTO;
import com.Guiderr.v1.repository.CategoryRepository;

@Component
public class ProductMapper {

    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ProductResponseDTO toResponseDTO(Product product) {
        ProductResponseDTO response = new ProductResponseDTO();
        response.setSku(product.getSku());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setBrand(product.getBrand());

        if (product.getCategory() != null) {
            response.setCategoryId(product.getCategory().getID());
            response.setCategoryName(product.getCategory().getName());
        }

        response.setCreatedAt(product.getCreatedat());
        response.setPrice(product.getPrice());
        return response;
    }

    public Product toEntity(ProductCreateRequestDTO request) {
        Product product = new Product();
        product.setSku(request.getSku());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setBrand(request.getBrand());
        product.setPrice(request.getPrice());

        product.setCategory(
            categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category ID not found"))
        );
        return product;
    }

    public void updateEntity(Product product, ProductUpdateRequestDTO request) {
        if (request.getSku() != null) product.setSku(request.getSku());
        if (request.getName() != null) product.setName(request.getName());
        if (request.getDescription() != null) product.setDescription(request.getDescription());
        if (request.getBrand() != null) product.setBrand(request.getBrand());
        if (request.getPrice() != null) product.setPrice(request.getPrice());

        if (request.getCategoryId() != null) {
            product.setCategory(
                categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category ID not found"))
            );
        }
    }
}
