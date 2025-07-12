package com.Guiderr.v1.web;

import com.Guiderr.v1.model.dto.request.*;
import com.Guiderr.v1.model.dto.response.*;
import com.Guiderr.v1.service.StoreService;
import com.Guiderr.v1.utils.ApiResponse;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/id")
    public ResponseEntity<ApiResponse<StoreResponseDTO>> getStoreById(@RequestBody @Valid StoreByIdRequestDTO request) {
        try {
            StoreResponseDTO store = storeService.getStoreByID(request);
            return ResponseEntity.ok(ApiResponse.success("Store found by ID", store));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping("/name")
    public ResponseEntity<ApiResponse<List<StoreResponseDTO>>> getStoreByName(@RequestBody @Valid StoreByNameRequestDTO request) {
        try {
            List<StoreResponseDTO> store = storeService.getStoreByName(request);
            return ResponseEntity.ok(ApiResponse.success("Store found by name", store));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<StoreResponseDTO>>> getAllStores() {
        try {
            List<StoreResponseDTO> stores = storeService.getAllStores();
            return ResponseEntity.ok(ApiResponse.success("All stores fetched", stores));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StoreResponseDTO>> createStore(@RequestBody @Valid StoreCreateRequestDTO request) {
        try {
            StoreResponseDTO store = storeService.createStoreDetails(request);
            return ResponseEntity.ok(ApiResponse.success("Store created", store));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @PutMapping
    public ResponseEntity<ApiResponse<StoreResponseDTO>> updateStore(@RequestBody @Valid StoreUpdateRequestDTO request) {
        try {
            StoreResponseDTO store = storeService.updateStoreDetails(request);
            return ResponseEntity.ok(ApiResponse.success("Store updated", store));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<StoreResponseDTO>> deleteStore(@RequestBody @Valid StoreDeleteByIdRequestDTO request) {
        try {
            StoreResponseDTO store = storeService.deleteStoreDetails(request);
            return ResponseEntity.ok(ApiResponse.success("Store deleted", store));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }
    
    @PostMapping("/grid")
    public ResponseEntity<ApiResponse<GridResponseDTO>> getStoreGrid(@RequestBody @Valid StoreByIdRequestDTO request){
    	try {
            GridResponseDTO grid = storeService.getStoreGrid(request);
            return ResponseEntity.ok(ApiResponse.success("Grid found: ", grid));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }
    
    @PostMapping("/grid-new")
    public ResponseEntity<ApiResponse<StoreResponseDTO>> setStoreGrid(@RequestBody @Valid GridRequestDTO request){
    	try {
            StoreResponseDTO store = storeService.createStoreGrid(request);
            return ResponseEntity.ok(ApiResponse.success("Grid found: ", store));
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(ApiResponse.failure(e.getReason()), e.getStatusCode());
        }
    }
}