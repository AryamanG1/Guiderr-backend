package com.Guiderr.v1.model.dto.response;

import java.sql.Timestamp;
import java.util.UUID;

import com.Guiderr.v1.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ProductResponseDTO {
    private String sku;
    private String name;
    private String description;
    private String brand;
    private Long categoryId;
    private String categoryName;
    private Timestamp createdAt;
    private Long price;
    
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
    
    

}
