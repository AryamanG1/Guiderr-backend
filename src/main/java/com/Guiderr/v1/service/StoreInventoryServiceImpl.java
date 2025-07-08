package com.Guiderr.v1.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.Guiderr.v1.mapper.StoreInventoryMapper;
import com.Guiderr.v1.model.*;
import com.Guiderr.v1.model.dto.request.*;
import com.Guiderr.v1.model.dto.response.*;
import com.Guiderr.v1.repository.*;

import jakarta.transaction.Transactional;

@Service
public class StoreInventoryServiceImpl implements StoreInventoryService {

    private static final Logger logger = LoggerFactory.getLogger(StoreInventoryServiceImpl.class);

    private final StoreRepository storeRepository;
    private final StoreInventoryRepository storeInventoryRepository;
    private final ProductRepository productRepository;
    private final StoreInventoryMapper storeInventoryMapper;

    public StoreInventoryServiceImpl(StoreRepository storeRepository,
                                     StoreInventoryRepository storeInventoryRepository,
                                     StoreInventoryMapper storeInventoryMapper,
                                     ProductRepository productRepository) {
        this.storeRepository = storeRepository;
        this.storeInventoryRepository = storeInventoryRepository;
        this.storeInventoryMapper = storeInventoryMapper;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductShortResponseDTO> getStoreProducts(ProductsByStoreIdRequestDTO request) {
        logger.trace("Entering getStoreProducts with store ID: {}", request.getStoreID());

        Store store = storeRepository.findById(request.getStoreID())
                .orElseThrow(() -> {
                    logger.error("Store not found with ID: {}", request.getStoreID());
                    return new RuntimeException("Could not find Store with Store ID " + request.getStoreID());
                });

        List<StoreInventory> items = storeInventoryRepository.findByID_StoreID(request.getStoreID());
        logger.debug("Found {} inventory items for store ID {}", items.size(), request.getStoreID());

        List<ProductShortResponseDTO> response = items.stream()
                .map(storeInventoryMapper::toResponseDTO)
                .collect(Collectors.toList());

        logger.trace("Exiting getStoreProducts with {} products", response.size());
        return response;
    }

    @Override
    public List<StoreShortResponseDTO> getProductStores(StoreHavingProductRequestDTO request) {
        logger.trace("Entering getProductStores with product ID: {}", request.getProductID());

        Product product = productRepository.findById(request.getProductID())
                .orElseThrow(() -> {
                    logger.error("Product not found with ID: {}", request.getProductID());
                    return new RuntimeException("Could not find Product with Product ID " + request.getProductID());
                });

        List<StoreInventory> items = storeInventoryRepository.findByID_ProductID(request.getProductID());
        logger.debug("Found {} stores for product ID {}", items.size(), request.getProductID());

        List<StoreShortResponseDTO> response = items.stream()
                .map(storeInventoryMapper::toStoreResponseDTO)
                .collect(Collectors.toList());

        logger.trace("Exiting getProductStores with {} stores", response.size());
        return response;
    }

    @Override
    public ProductShortResponseDTO addProductStore(AddProductStoreRequestDTO request) {
        logger.trace("Entering addProductStore for store ID: {}, product ID: {}", request.getStoreId(), request.getProductId());

        StoreInventory store = storeInventoryMapper.toEntity(request);
        storeInventoryRepository.save(store);

        logger.debug("Saved product {} to store {}", request.getProductId(), request.getStoreId());
        logger.trace("Exiting addProductStore");
        return storeInventoryMapper.toResponseDTO(store);
    }

    @Override
    public ProductShortResponseDTO removeProductStore(RemoveProductStoreRequestDTO request) {
        logger.trace("Entering removeProductStore for store ID: {}, product ID: {}", request.getStoreId(), request.getProductId());

        StoreInventoryKey key = new StoreInventoryKey(request.getStoreId(), request.getProductId());
        StoreInventory storeIv = storeInventoryRepository.findById(key)
                .orElseThrow(() -> {
                    logger.error("StoreInventory not found for key: {}", key);
                    return new RuntimeException("Could Not Find Store Inventory Object");
                });

        storeInventoryRepository.delete(storeIv);
        logger.debug("Removed product {} from store {}", request.getProductId(), request.getStoreId());
        logger.trace("Exiting removeProductStore");
        return storeInventoryMapper.toResponseDTO(storeIv);
    }

    @Override
    public ProductShortResponseDTO updateProductQuantityStore(UpdateProductStoreQuantityRequestDTO request) {
        logger.trace("Entering updateProductQuantityStore for store ID: {}, product ID: {}", request.getStoreId(), request.getProductId());

        StoreInventoryKey key = new StoreInventoryKey(request.getStoreId(), request.getProductId());
        StoreInventory storeIv = storeInventoryRepository.findById(key)
                .orElseThrow(() -> {
                    logger.error("StoreInventory not found for key: {}", key);
                    return new RuntimeException("Could Not Find Store Inventory Object");
                });

        storeIv.setQuantity(request.getQuantity());
        storeInventoryRepository.save(storeIv);

        logger.debug("Updated quantity to {} for product ID {} in store ID {}", request.getQuantity(), request.getProductId(), request.getStoreId());
        logger.trace("Exiting updateProductQuantityStore");
        return storeInventoryMapper.toResponseDTO(storeIv);
    }

    @Override
    public ProductShortResponseDTO updateProductRestockThresholdStore(UpdateProductStoreRestockRequestDTO request) {
        logger.trace("Entering updateProductRestockThresholdStore for store ID: {}, product ID: {}", request.getStoreId(), request.getProductId());

        StoreInventoryKey key = new StoreInventoryKey(request.getStoreId(), request.getProductId());
        StoreInventory storeIv = storeInventoryRepository.findById(key)
                .orElseThrow(() -> {
                    logger.error("StoreInventory not found for key: {}", key);
                    return new RuntimeException("Could Not Find Store Inventory Object");
                });

        storeIv.setRestockThreshold(request.getRestockThreshold());
        storeInventoryRepository.save(storeIv);

        logger.debug("Updated restock threshold to {} for product ID {} in store ID {}", request.getRestockThreshold(), request.getProductId(), request.getStoreId());
        logger.trace("Exiting updateProductRestockThresholdStore");
        return storeInventoryMapper.toResponseDTO(storeIv);
    }

    @Override
    public ProductShortResponseDTO findProductByIdInStore(ProductsByIdInStoreRequestDTO request) {
        logger.trace("Entering findProductByIdInStore for store ID: {}, product ID: {}", request.getStoreId(), request.getProductId());

        StoreInventoryKey key = new StoreInventoryKey(request.getStoreId(), request.getProductId());
        StoreInventory storeIv = storeInventoryRepository.findById(key)
                .orElseThrow(() -> {
                    logger.error("StoreInventory not found for key: {}", key);
                    return new RuntimeException("Could Not Find Store Inventory Object");
                });

        logger.trace("Exiting findProductByIdInStore");
        return storeInventoryMapper.toResponseDTO(storeIv);
    }

    @Override
    @Transactional
    public ProductShortResponseDTO findProductBySkuInStore(ProductsBySkuInStoreRequestDTO request) {
        logger.trace("Entering findProductBySkuInStore for store ID: {}, SKU: {}", request.getStoreId(), request.getSku());

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> {
                    logger.error("Store not found with ID: {}", request.getStoreId());
                    return new RuntimeException("Store not found with ID: " + request.getStoreId());
                });

        Product product = productRepository.findProductBySku(request.getSku())
                .orElseThrow(() -> {
                    logger.error("Product not found with SKU: {}", request.getSku());
                    return new RuntimeException("Product with SKU " + request.getSku() + " not found.");
                });

        StoreInventoryKey key = new StoreInventoryKey(store.getID(), product.getID());
        StoreInventory inventory = storeInventoryRepository.findById(key)
                .orElseThrow(() -> {
                    logger.error("Product with SKU {} not found in store inventory", request.getSku());
                    return new RuntimeException("Product with SKU " + request.getSku() + " not found in store inventory.");
                });

        logger.trace("Exiting findProductBySkuInStore");
        return storeInventoryMapper.toResponseDTO(inventory);
    }

    @Override
    @Transactional
    public List<ProductShortResponseDTO> findProductByNameInStore(ProductsByNameInStoreRequestDTO request) {
        logger.trace("Entering findProductByNameInStore for store ID: {}, name: {}", request.getStoreId(), request.getName());

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> {
                    logger.error("Store not found with ID: {}", request.getStoreId());
                    return new RuntimeException("Store not found with ID: " + request.getStoreId());
                });

        List<Product> products = productRepository.findByNameContaining(request.getName());

        List<ProductShortResponseDTO> response = products.stream()
                .map(product -> {
                    StoreInventoryKey key = new StoreInventoryKey(store.getID(), product.getID());
                    StoreInventory inventory = storeInventoryRepository.findById(key).orElse(null);
                    return inventory != null ? storeInventoryMapper.toResponseDTO(inventory) : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        logger.debug("Found {} matching products by name '{}' in store ID {}", response.size(), request.getName(), request.getStoreId());
        logger.trace("Exiting findProductByNameInStore");
        return response;
    }

    @Override
    @Transactional
    public List<ProductShortResponseDTO> findProductByBrandInStore(ProductsByBrandInStoreRequestDTO request) {
        logger.trace("Entering findProductByBrandInStore for store ID: {}, brand: {}", request.getStoreId(), request.getBrand());

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> {
                    logger.error("Store not found with ID: {}", request.getStoreId());
                    return new RuntimeException("Store not found with ID: " + request.getStoreId());
                });

        List<Product> products = productRepository.findProductByBrand(request.getBrand());

        List<ProductShortResponseDTO> response = products.stream()
                .map(product -> {
                    StoreInventoryKey key = new StoreInventoryKey(store.getID(), product.getID());
                    StoreInventory inventory = storeInventoryRepository.findById(key).orElse(null);
                    return inventory != null ? storeInventoryMapper.toResponseDTO(inventory) : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        logger.debug("Found {} matching products by brand '{}' in store ID {}", response.size(), request.getBrand(), request.getStoreId());
        logger.trace("Exiting findProductByBrandInStore");
        return response;
    }

    @Override
    @Transactional
    public List<ProductShortResponseDTO> findProductByPriceRangeInStore(ProductsByPriceRangeInStoreRequestDTO request) {
        logger.trace("Entering findProductByPriceRangeInStore for store ID: {}, price range: {} - {}",
                request.getStoreId(), request.getMinPrice(), request.getMaxPrice());

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> {
                    logger.error("Store not found with ID: {}", request.getStoreId());
                    return new RuntimeException("Store not found with ID: " + request.getStoreId());
                });

        List<Product> products = productRepository.findByPriceBetween(request.getMinPrice(), request.getMaxPrice());

        List<ProductShortResponseDTO> response = products.stream()
                .map(product -> {
                    StoreInventoryKey key = new StoreInventoryKey(store.getID(), product.getID());
                    StoreInventory inventory = storeInventoryRepository.findById(key).orElse(null);
                    return inventory != null ? storeInventoryMapper.toResponseDTO(inventory) : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        logger.debug("Found {} products in price range {} - {} for store ID {}",
                response.size(), request.getMinPrice(), request.getMaxPrice(), request.getStoreId());
        logger.trace("Exiting findProductByPriceRangeInStore");
        return response;
    }
}