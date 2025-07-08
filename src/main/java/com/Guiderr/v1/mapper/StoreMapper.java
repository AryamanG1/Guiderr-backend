package com.Guiderr.v1.mapper;

import org.springframework.stereotype.Component;

import com.Guiderr.v1.model.Store;
import com.Guiderr.v1.model.dto.request.StoreCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreUpdateRequestDTO;
import com.Guiderr.v1.model.dto.response.StoreResponseDTO;
@Component
public class StoreMapper {

	public static StoreResponseDTO toResponseDTO(Store store) {
        StoreResponseDTO dto = new StoreResponseDTO();
        dto.setStoreId(store.getID());
        dto.setName(store.getName());
        dto.setLocation(store.getLocation());
        dto.setLength(store.getLength());
        dto.setWidth(store.getWidth());
        dto.setGridSize(store.getGridunitsize());
        dto.setCreatedAt(store.getCreatedata());

        return dto;
    }
	
	public static Store toEntity(StoreCreateRequestDTO request) {
        Store store = new Store();
        store.setName(request.getName());
        store.setLocation(request.getLocation());
        store.setLength(request.getLength());
        store.setWidth(request.getWidth());
        store.setGridunitsize(request.getGridUnitSize());
        return store;
    }
	
	public static void updateEntity(Store existing, StoreUpdateRequestDTO request) {
        if (request.getName() != null) {
            existing.setName(request.getName());
        }
        if (request.getLocation() != null) {
            existing.setLocation(request.getLocation());
        }
        if (request.getLength() != null) {
            existing.setLength(request.getLength());
        }
        if (request.getWidth() != null) {
            existing.setWidth(request.getWidth());
        }
        if (request.getGridUnitSize() != 0) {
            existing.setGridunitsize(request.getGridUnitSize());
        }
    }
	
}
