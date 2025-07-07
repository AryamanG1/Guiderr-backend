package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


public class ProductsBySkuRequestDTO {
	@NotBlank
    private String sku;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
}
