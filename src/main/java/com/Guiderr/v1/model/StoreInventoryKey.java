package com.Guiderr.v1.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StoreInventoryKey implements Serializable {
	
	@Column(name="store_id")
	private UUID storeID;
	
	@Column(name="product_id")
	private UUID productID;

	

	public StoreInventoryKey(UUID storeID, UUID productID) {
		this.storeID = storeID;
		this.productID = productID;
	}

	public StoreInventoryKey() {
	}

	public UUID getStoreID() {
		return storeID;
	}

	public void setStoreID(UUID storeID) {
		this.storeID = storeID;
	}

	public UUID getProductID() {
		return productID;
	}

	public void setProductID(UUID productID) {
		this.productID = productID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productID, storeID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreInventoryKey other = (StoreInventoryKey) obj;
		return Objects.equals(productID, other.productID) && Objects.equals(storeID, other.storeID);
	}
	
	
	
}
