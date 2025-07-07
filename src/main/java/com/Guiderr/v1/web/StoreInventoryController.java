package com.Guiderr.v1.web;

import com.Guiderr.v1.model.dto.request.*;
import com.Guiderr.v1.model.dto.response.ProductShortResponseDTO;
import com.Guiderr.v1.model.dto.response.StoreShortResponseDTO;
import com.Guiderr.v1.service.StoreInventoryService;
import com.Guiderr.v1.utils.ApiResponse;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/store-inventory")
public class StoreInventoryController {

    private final StoreInventoryService storeInventoryService;

    public StoreInventoryController(StoreInventoryService storeInventoryService) {
        this.storeInventoryService = storeInventoryService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductShortResponseDTO>> add(@RequestBody @Valid AddProductStoreRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Product added", storeInventoryService.addProductStore(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<ProductShortResponseDTO>> remove(@RequestBody @Valid RemoveProductStoreRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Product removed", storeInventoryService.removeProductStore(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PutMapping("/quantity")
    public ResponseEntity<ApiResponse<ProductShortResponseDTO>> updateQuantity(@RequestBody @Valid UpdateProductStoreQuantityRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Quantity updated", storeInventoryService.updateProductQuantityStore(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PutMapping("/restock-threshold")
    public ResponseEntity<ApiResponse<ProductShortResponseDTO>> updateRestockThreshold(@RequestBody @Valid UpdateProductStoreRestockRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Restock threshold updated", storeInventoryService.updateProductRestockThresholdStore(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/products")
    public ResponseEntity<ApiResponse<List<ProductShortResponseDTO>>> getProducts(@RequestBody @Valid ProductsByStoreIdRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Products in store", storeInventoryService.getStoreProducts(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/stores")
    public ResponseEntity<ApiResponse<List<StoreShortResponseDTO>>> getStores(@RequestBody @Valid StoreHavingProductRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Stores having product", storeInventoryService.getProductStores(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    // ==== Filters ====

    @PostMapping("/filter/id")
    public ResponseEntity<ApiResponse<ProductShortResponseDTO>> filterById(@RequestBody @Valid ProductsByIdInStoreRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Product found by ID", storeInventoryService.findProductByIdInStore(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/filter/sku")
    public ResponseEntity<ApiResponse<ProductShortResponseDTO>> filterBySku(@RequestBody @Valid ProductsBySkuInStoreRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Product found by SKU", storeInventoryService.findProductBySkuInStore(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/filter/name")
    public ResponseEntity<ApiResponse<List<ProductShortResponseDTO>>> filterByName(@RequestBody @Valid ProductsByNameInStoreRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Products found by name", storeInventoryService.findProductByNameInStore(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/filter/brand")
    public ResponseEntity<ApiResponse<List<ProductShortResponseDTO>>> filterByBrand(@RequestBody @Valid ProductsByBrandInStoreRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Products found by brand", storeInventoryService.findProductByBrandInStore(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/filter/price")
    public ResponseEntity<ApiResponse<List<ProductShortResponseDTO>>> filterByPrice(@RequestBody @Valid ProductsByPriceRangeInStoreRequestDTO request) {
        try {
            return ResponseEntity.ok(ApiResponse.success("Products found by price range", storeInventoryService.findProductByPriceRangeInStore(request)));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }
}

