package com.Guiderr.v1.model.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class UpdateProductStoreRestockRequestDTO {
	 	@NotNull
	    private UUID storeId;

	    @NotNull
	    private UUID productId;
	    
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

		public int getRestockThreshold() {
			return restockThreshold;
		}

		public void setRestockThreshold(int restockThreshold) {
			this.restockThreshold = restockThreshold;
		}

}
