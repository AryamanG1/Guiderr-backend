package com.Guiderr.v1.model.dto.request;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class StoreHavingProductRequestDTO {
	
	@NotNull(message="Product ID cannot be empty")
	private UUID productID;

	public UUID getProductID() {
		return productID;
	}

	public void setProductID(UUID productID) {
		this.productID = productID;
	}
	
	
}
