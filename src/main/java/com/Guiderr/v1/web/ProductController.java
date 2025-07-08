package com.Guiderr.v1.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.Guiderr.v1.model.dto.request.ProductCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductDeleteRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductUpdateRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByBrandRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByIdRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByNameRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByPriceRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsBySkuRequestDTO;
import com.Guiderr.v1.model.dto.response.ProductResponseDTO;
import com.Guiderr.v1.service.ProductService;
import com.Guiderr.v1.utils.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product/id")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> getProductByID(@RequestBody @Valid ProductsByIdRequestDTO request) {
        try {
            ProductResponseDTO prod = productService.getProductById(request);
            return ResponseEntity.ok(ApiResponse.success("Found Product by ID", prod));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/product/sku")
    
    public ResponseEntity<ApiResponse<ProductResponseDTO>> getProductBySKU(@RequestBody @Valid ProductsBySkuRequestDTO request) {
        try {
            ProductResponseDTO prod = productService.getProductBySku(request);
            return ResponseEntity.ok(ApiResponse.success("Found Product by SKU", prod));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/product/name")
    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getProductByName(@RequestBody @Valid ProductsByNameRequestDTO request) {
        try {
            List<ProductResponseDTO> prod = productService.getProductsByName(request);
            return ResponseEntity.ok(ApiResponse.success("Found Products by Name", prod));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/product/brand")
    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getProductByBrand(@RequestBody @Valid ProductsByBrandRequestDTO request) {
        try {
            List<ProductResponseDTO> prod = productService.getProductsByBrand(request);
            return ResponseEntity.ok(ApiResponse.success("Found Product by Brand", prod));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @GetMapping("/products")
    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getAllProducts() {
        try {
            List<ProductResponseDTO> prod = productService.getAllProducts();
            return ResponseEntity.ok(ApiResponse.success("Found All Products", prod));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/product/price")
    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getProductsByPrice(@RequestBody @Valid ProductsByPriceRequestDTO request) {
        try {
            List<ProductResponseDTO> prod = productService.getProductsByPrice(request);
            return ResponseEntity.ok(ApiResponse.success("Found Products by Price", prod));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/product")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> createProduct(@RequestBody @Valid ProductCreateRequestDTO request) {
        try {
            ProductResponseDTO prod = productService.createProduct(request);
            return ResponseEntity.ok(ApiResponse.success("Created Product", prod));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @DeleteMapping("/product")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> deleteProduct(@RequestBody @Valid ProductDeleteRequestDTO request) {
        try {
            ProductResponseDTO prod = productService.deleteProduct(request);
            return ResponseEntity.ok(ApiResponse.success("Deleted product", prod));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PutMapping("/product")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> updateProduct(@RequestBody @Valid ProductUpdateRequestDTO request) {
        try {
            ProductResponseDTO prod = productService.updateProduct(request);
            return ResponseEntity.ok(ApiResponse.success("Updated Product", prod));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }
}