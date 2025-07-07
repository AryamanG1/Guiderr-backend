package com.Guiderr.v1.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ProductsByPriceRequestDTO {
	@NotNull(message = "Lower price limit cannot be null")
    private Long lowerPrice;

    @NotNull(message = "Upper price limit cannot be null")
    private Long upperPrice;

	public Long getLowerPrice() {
		return lowerPrice;
	}

	public void setLowerPrice(Long lowerPrice) {
		this.lowerPrice = lowerPrice;
	}

	public Long getUpperPrice() {
		return upperPrice;
	}

	public void setUpperPrice(Long upperPrice) {
		this.upperPrice = upperPrice;
	}
    
    
}
