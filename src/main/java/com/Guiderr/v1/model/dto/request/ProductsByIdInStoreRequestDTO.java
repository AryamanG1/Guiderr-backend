package com.Guiderr.v1.model.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


public class ProductsByIdInStoreRequestDTO {
    @NotNull
    private UUID storeId;

    @NotNull
    private UUID productId;

	public UUID getStoreId() {
		return storeId;
	}

	public void setStoreId(UUID storeId) {
		this.storeId = storeId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

    
}