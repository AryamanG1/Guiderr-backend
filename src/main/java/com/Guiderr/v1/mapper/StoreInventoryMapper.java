package com.Guiderr.v1.mapper;
import org.springframework.stereotype.Component;

import com.Guiderr.v1.model.Product;
import com.Guiderr.v1.model.Store;
import com.Guiderr.v1.model.StoreInventory;
import com.Guiderr.v1.model.StoreInventoryKey;
import com.Guiderr.v1.model.dto.request.AddProductStoreRequestDTO;
import com.Guiderr.v1.model.dto.response.ProductShortResponseDTO;
import com.Guiderr.v1.model.dto.response.StoreShortResponseDTO;
import com.Guiderr.v1.repository.ProductRepository;
import com.Guiderr.v1.repository.StoreRepository;


@Component
public class StoreInventoryMapper {

	private final StoreRepository storeRepository;
	private final ProductRepository productRepository;
	
	
	
	
	public StoreInventoryMapper(StoreRepository storeRepository, ProductRepository productRepository) {
		this.storeRepository = storeRepository;
		this.productRepository = productRepository;
	}

	public ProductShortResponseDTO toResponseDTO(StoreInventory storeInventory) {
		ProductShortResponseDTO response = new ProductShortResponseDTO();
		response.setProductName(storeInventory.getProduct().getName());
		response.setProductId(storeInventory.getProduct().getID());
		response.setStoreId(storeInventory.getStore().getID());
		response.setLastRestocked(storeInventory.getLastRestocked());
		response.setQuantity(storeInventory.getQuantity());
		response.setX(storeInventory.getX());
		response.setY(storeInventory.getY());
		response.setRestockThreshold(storeInventory.getRestockThreshold());

		return response;
	}
	
	public StoreShortResponseDTO toStoreResponseDTO(StoreInventory storeInventory) {
		Store store = storeRepository.findById(storeInventory.getID().getStoreID()).orElseThrow(() -> new RuntimeException("Store ID is invalid"));
		StoreShortResponseDTO response = new StoreShortResponseDTO();
		response.setName(store.getName());
		response.setLocation(store.getLocation());
		response.setStoreID(store.getID());
		return response;
	}
	
	public StoreInventory toEntity(AddProductStoreRequestDTO request) {
		Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new RuntimeException("Store ID is invalid"));
		Product product = productRepository.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product ID is invalid"));
		
		StoreInventory storeInventory = new StoreInventory();
		StoreInventoryKey key = new StoreInventoryKey();
		
		key.setProductID(request.getProductId());
		key.setStoreID(request.getStoreId());
		
		storeInventory.setID(key);
		storeInventory.setProduct(product);
		storeInventory.setStore(store);
		storeInventory.setRestockThreshold(request.getRestockThreshold());
		storeInventory.setQuantity(request.getQuantity());
		storeInventory.setX(request.getX());
		storeInventory.setY(request.getY());
		
		return storeInventory;

	}
	
}

