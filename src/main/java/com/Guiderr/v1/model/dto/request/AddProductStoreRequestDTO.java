package com.Guiderr.v1.model.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class AddProductStoreRequestDTO {
    @NotNull
    private UUID storeId;

    @NotNull
    private UUID productId;

    @Min(0)
    private int x;

    @Min(0)
    private int y;

    @Min(0)
    private int quantity;

    @Min(0)
    private int restockThreshold;

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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRestockThreshold() {
		return restockThreshold;
	}

	public void setRestockThreshold(int restockThreshold) {
		this.restockThreshold = restockThreshold;
	}
    
    
}
