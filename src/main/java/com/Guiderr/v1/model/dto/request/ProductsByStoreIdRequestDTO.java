package com.Guiderr.v1.model.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class ProductsByStoreIdRequestDTO {
	@NotNull(message="Store ID cannot be empty")
	private UUID storeID;

	public UUID getStoreID() {
		return storeID;
	}

	public void setStoreID(UUID storeID) {
		this.storeID = storeID;
	}
	
	
}
