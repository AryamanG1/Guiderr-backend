package com.Guiderr.v1.service;

import java.util.List;

import com.Guiderr.v1.model.dto.request.GridRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreByIdRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreByNameRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreDeleteByIdRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreUpdateRequestDTO;
import com.Guiderr.v1.model.dto.response.GridResponseDTO;
import com.Guiderr.v1.model.dto.response.StoreResponseDTO;

public interface StoreService {
			
	StoreResponseDTO getStoreByID(StoreByIdRequestDTO request);
	List<StoreResponseDTO> getStoreByName(StoreByNameRequestDTO request);
	List<StoreResponseDTO> getAllStores();
	StoreResponseDTO createStoreDetails(StoreCreateRequestDTO request);
	StoreResponseDTO updateStoreDetails(StoreUpdateRequestDTO request);
	StoreResponseDTO deleteStoreDetails(StoreDeleteByIdRequestDTO request);
	StoreResponseDTO createStoreGrid(GridRequestDTO request);
	GridResponseDTO getStoreGrid(StoreByIdRequestDTO request);
}
