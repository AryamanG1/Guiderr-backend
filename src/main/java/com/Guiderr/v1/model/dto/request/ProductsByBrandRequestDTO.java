package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotBlank;


public class ProductsByBrandRequestDTO {
	@NotBlank
    private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
