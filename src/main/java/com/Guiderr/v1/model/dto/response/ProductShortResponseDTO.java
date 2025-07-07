package com.Guiderr.v1.model.dto.response;

import java.sql.Timestamp;
import java.util.UUID;


public class ProductShortResponseDTO {
	
	 	private UUID storeId;
	    private UUID productId;
	    private int x;
	    private int y;
	    private int quantity;
	    private int restockThreshold;
	    private Timestamp lastRestocked;
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
		public Timestamp getLastRestocked() {
			return lastRestocked;
		}
		public void setLastRestocked(Timestamp lastRestocked) {
			this.lastRestocked = lastRestocked;
		}
	    
	    

}
