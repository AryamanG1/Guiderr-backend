package com.Guiderr.v1.service;

import java.util.List;

import com.Guiderr.v1.model.dto.request.ProductCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductDeleteRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductUpdateRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByBrandRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByIdRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByNameRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByPriceRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsBySkuRequestDTO;
import com.Guiderr.v1.model.dto.response.ProductResponseDTO;


public interface ProductService {
    ProductResponseDTO getProductById(ProductsByIdRequestDTO request);
    ProductResponseDTO getProductBySku(ProductsBySkuRequestDTO request);
    List<ProductResponseDTO> getProductsByName(ProductsByNameRequestDTO request);
    List<ProductResponseDTO> getProductsByBrand(ProductsByBrandRequestDTO request);
    List<ProductResponseDTO> getAllProducts();
    List<ProductResponseDTO> getProductsByPrice(ProductsByPriceRequestDTO request);
    ProductResponseDTO createProduct(ProductCreateRequestDTO request);
    ProductResponseDTO deleteProduct(ProductDeleteRequestDTO request);
    ProductResponseDTO updateProduct(ProductUpdateRequestDTO request);
}
