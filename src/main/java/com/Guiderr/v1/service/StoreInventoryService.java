
package com.Guiderr.v1.service;

import java.util.List;

import com.Guiderr.v1.model.dto.request.AddProductStoreRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByBrandInStoreRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByIdInStoreRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByNameInStoreRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByPriceRangeInStoreRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsBySkuInStoreRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByStoreIdRequestDTO;
import com.Guiderr.v1.model.dto.request.RemoveProductStoreRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreHavingProductRequestDTO;
import com.Guiderr.v1.model.dto.request.UpdateProductStoreQuantityRequestDTO;
import com.Guiderr.v1.model.dto.request.UpdateProductStoreRestockRequestDTO;
import com.Guiderr.v1.model.dto.response.ProductShortResponseDTO;
import com.Guiderr.v1.model.dto.response.StoreShortResponseDTO;

public interface StoreInventoryService {
	// Functionality of Checking of store in product , and product in which stores
	List<ProductShortResponseDTO> getStoreProducts(ProductsByStoreIdRequestDTO request);
	List<StoreShortResponseDTO> getProductStores(StoreHavingProductRequestDTO request);
	
	// Functionality of CRUD of aggregate items
	ProductShortResponseDTO addProductStore(AddProductStoreRequestDTO request);
	ProductShortResponseDTO removeProductStore(RemoveProductStoreRequestDTO request);
	ProductShortResponseDTO updateProductQuantityStore(UpdateProductStoreQuantityRequestDTO request);
	ProductShortResponseDTO updateProductRestockThresholdStore(UpdateProductStoreRestockRequestDTO request);
	
	// Advanced Filtering
	ProductShortResponseDTO findProductByIdInStore(ProductsByIdInStoreRequestDTO request);
    ProductShortResponseDTO findProductBySkuInStore(ProductsBySkuInStoreRequestDTO request);
    List<ProductShortResponseDTO> findProductByNameInStore(ProductsByNameInStoreRequestDTO request);
    List<ProductShortResponseDTO> findProductByBrandInStore(ProductsByBrandInStoreRequestDTO request);
    List<ProductShortResponseDTO> findProductByPriceRangeInStore(ProductsByPriceRangeInStoreRequestDTO request);
}
