package com.Guiderr.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.Guiderr.v1.mapper.StoreMapper;
import com.Guiderr.v1.model.Store;
import com.Guiderr.v1.model.dto.request.GridRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreByIdRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreByNameRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreDeleteByIdRequestDTO;
import com.Guiderr.v1.model.dto.request.StoreUpdateRequestDTO;
import com.Guiderr.v1.model.dto.response.GridResponseDTO;
import com.Guiderr.v1.model.dto.response.StoreResponseDTO;
import com.Guiderr.v1.repository.StoreRepository;





@Service
public class StoreServiceImpl implements StoreService {

	private final StoreRepository storeRepository;
	private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

	
	
	
	public StoreServiceImpl(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	@Override
	public StoreResponseDTO getStoreByID(StoreByIdRequestDTO request) {
		logger.trace("Entered getStoreByID() with ID: {}", request.getID());

		Store store = storeRepository.findById(request.getID())
			.orElseThrow(() -> {
				logger.error("Store ID {} is invalid", request.getID());
				return new RuntimeException("Store ID is invalid");
			});

		logger.debug("Found store: {}", store.getName());
		logger.trace("Exiting getStoreByID()");
		return StoreMapper.toResponseDTO(store);
	}

	@Override
	public List<StoreResponseDTO> getStoreByName(StoreByNameRequestDTO request) {
		logger.trace("Entered getStoreByName() with name: {}", request.getName());

		List<Store> stores = storeRepository.findByNameContaining(request.getName());

		logger.debug("Retrieved {} stores", stores.size());
		List<StoreResponseDTO> responseList = stores.stream()
			.map(StoreMapper::toResponseDTO)
			.collect(Collectors.toList());

		logger.trace("Exiting getAllStores()");
		return responseList;
	}

	@Override
	public List<StoreResponseDTO> getAllStores() {
		logger.trace("Entered getAllStores()");
		List<Store> stores = storeRepository.findAll();

		logger.debug("Retrieved {} stores", stores.size());
		List<StoreResponseDTO> responseList = stores.stream()
			.map(StoreMapper::toResponseDTO)
			.collect(Collectors.toList());

		logger.trace("Exiting getAllStores()");
		return responseList;
	}

	@Override
	public StoreResponseDTO createStoreDetails(StoreCreateRequestDTO request) {
		logger.trace("Entered createStoreDetails() with request: {}", request);

		Store store = StoreMapper.toEntity(request);
		storeRepository.save(store);

		logger.info("Created new store with name: {}", store.getName());
		logger.trace("Exiting createStoreDetails()");
		return StoreMapper.toResponseDTO(store);
	}

	@Override
	public StoreResponseDTO updateStoreDetails(StoreUpdateRequestDTO request) {
		logger.trace("Entered updateStoreDetails() with ID: {}", request.getID());

		Store store = storeRepository.findById(request.getID())
			.orElseThrow(() -> {
				logger.error("Store ID {} not found for update", request.getID());
				return new RuntimeException("Store ID is invalid");
			});

		StoreMapper.updateEntity(store, request);
		storeRepository.save(store);

		logger.info("Updated store with ID: {}", store.getID());
		logger.trace("Exiting updateStoreDetails()");
		return StoreMapper.toResponseDTO(store);
	}

	@Override
	public StoreResponseDTO deleteStoreDetails(StoreDeleteByIdRequestDTO request) {
		logger.trace("Entered deleteStoreDetails() with ID: {}", request.getID());

		Store store = storeRepository.findById(request.getID())
			.orElseThrow(() -> {
				logger.error("Store ID {} not found for deletion", request.getID());
				return new RuntimeException("Store ID is invalid");
			});

		storeRepository.delete(store);

		logger.warn("Deleted store with ID: {}", store.getID());
		logger.trace("Exiting deleteStoreDetails()");
		return StoreMapper.toResponseDTO(store);
	}

	@Override
	public GridResponseDTO getStoreGrid(StoreByIdRequestDTO request) {
		logger.trace("Entered getStoreGrid() with ID: {}", request.getID());
		Store store = storeRepository.findById(request.getID())
				.orElseThrow(() -> {
					logger.error("Store ID {} is invalid", request.getID());
					return new RuntimeException("Store ID is invalid");
				});
		
		logger.trace("Exited getStoreGrid() with ID: {}", request.getID());		
		return new GridResponseDTO(store.getGrid());
	}

	@Override
	public StoreResponseDTO createStoreGrid(GridRequestDTO request) {
		String grid = request.getGrid();
		Store store = storeRepository.findById(request.getId())
				.orElseThrow(() -> {
					logger.error("Store ID {} is invalid", request.getId());
					return new RuntimeException("Store ID is invalid");
				});
		
		store.setGrid(grid);
		storeRepository.save(store);
		
		return StoreMapper.toResponseDTO(store);
		
	}
}
