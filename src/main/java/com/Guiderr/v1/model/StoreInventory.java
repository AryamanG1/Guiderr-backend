package com.Guiderr.v1.model;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StoreInventory {
	
	@EmbeddedId
	private StoreInventoryKey ID;
	
	@Min(0)
	private int x;
	
	@Min(0)
	private int y;
	
	@Min(0)
	private int quantity;
	
	private int restockThreshold;
	
	@CreationTimestamp
	private Timestamp lastRestocked;
	
    @MapsId("storeID")
	@ManyToOne(optional = false)
	@JoinColumn(name = "store_id")
	private Store store;
	
    @MapsId("productID")
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Product product;

	public StoreInventoryKey getID() {
		return ID;
	}

	public void setID(StoreInventoryKey iD) {
		ID = iD;
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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    
	
	
}
