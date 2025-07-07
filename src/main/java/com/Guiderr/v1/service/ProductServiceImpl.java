package com.Guiderr.v1.service;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.Guiderr.v1.model.Product;
import com.Guiderr.v1.model.dto.request.ProductCreateRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductDeleteRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductUpdateRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByBrandRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByIdRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByNameRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsByPriceRequestDTO;
import com.Guiderr.v1.model.dto.request.ProductsBySkuRequestDTO;
import com.Guiderr.v1.model.dto.response.ProductResponseDTO;
import com.Guiderr.v1.repository.ProductRepository;
import com.Guiderr.v1.mapper.ProductMapper;


@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDTO getProductById(ProductsByIdRequestDTO request) {
        logger.trace("Entering getProductById with ID: {}", request.getId());
        Product product = productRepository.findById(request.getId())
            .orElseThrow(() -> {
                logger.error("Invalid Product ID: {}", request.getId());
                return new RuntimeException("Product ID is invalid");
            });
        ProductResponseDTO response = productMapper.toResponseDTO(product);
        logger.trace("Exiting getProductById");
        return response;
    }

    @Override
	public ProductResponseDTO getProductBySku(ProductsBySkuRequestDTO request) {
		Product product = productRepository.findProductBySku(request.getSku()).orElseThrow(() -> new RuntimeException("SKU is invalid"));
		return productMapper.toResponseDTO(product);
		
	}

    @Override
    public List<ProductResponseDTO> getProductsByName(ProductsByNameRequestDTO request) {
        logger.trace("Entering getProductsByName with name: {}", request.getName());
        List<Product> products = productRepository.findByNameContaining(request.getName());
        logger.debug("Found {} products with name containing: {}", products.size(), request.getName());
        List<ProductResponseDTO> response = products.stream()
            .map(productMapper::toResponseDTO)
            .collect(Collectors.toList());
        logger.trace("Exiting getProductsByName");
        return response;
    }

    @Override
    public List<ProductResponseDTO> getProductsByBrand(ProductsByBrandRequestDTO request) {
        logger.trace("Entering getProductsByBrand with brand: {}", request.getBrand());
        List<Product> products = productRepository.findProductByBrand(request.getBrand());
        logger.debug("Found {} products for brand: {}", products.size(), request.getBrand());
        List<ProductResponseDTO> response = products.stream()
            .map(productMapper::toResponseDTO)
            .collect(Collectors.toList());
        logger.trace("Exiting getProductsByBrand");
        return response;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        logger.trace("Entering getAllProducts");
        List<Product> products = productRepository.findAll();
        logger.debug("Fetched all products, count: {}", products.size());
        List<ProductResponseDTO> response = products.stream()
            .map(productMapper::toResponseDTO)
            .collect(Collectors.toList());
        logger.trace("Exiting getAllProducts");
        return response;
    }

    @Override
    public List<ProductResponseDTO> getProductsByPrice(ProductsByPriceRequestDTO request) {
        logger.trace("Entering getProductsByPrice with range: {} - {}", request.getLowerPrice(), request.getUpperPrice());
        List<Product> products = productRepository.findByPriceBetween(request.getLowerPrice(), request.getUpperPrice());
        logger.debug("Found {} products in price range", products.size());
        List<ProductResponseDTO> response = products.stream()
            .map(productMapper::toResponseDTO)
            .collect(Collectors.toList());
        logger.trace("Exiting getProductsByPrice");
        return response;
    }

    @Override
    public ProductResponseDTO createProduct(ProductCreateRequestDTO request) {
        logger.trace("Entering createProduct");
        Product product = productMapper.toEntity(request);
        productRepository.save(product);
        logger.debug("Created product with SKU: {}", product.getSku());
        ProductResponseDTO response = productMapper.toResponseDTO(product);
        logger.trace("Exiting createProduct");
        return response;
    }

    @Override
    public ProductResponseDTO deleteProduct(ProductDeleteRequestDTO request) {
        logger.trace("Entering deleteProduct with ID: {}", request.getId());
        Product product = productRepository.findById(request.getId())
            .orElseThrow(() -> {
                logger.error("Invalid Product ID for deletion: {}", request.getId());
                return new RuntimeException("Product ID is invalid");
            });
        productRepository.delete(product);
        logger.debug("Deleted product with ID: {}", product.getID());
        ProductResponseDTO response = productMapper.toResponseDTO(product);
        logger.trace("Exiting deleteProduct");
        return response;
    }

    @Override
    public ProductResponseDTO updateProduct(ProductUpdateRequestDTO request) {
        logger.trace("Entering updateProduct with ID: {}", request.getId());
        Product product = productRepository.findById(request.getId())
            .orElseThrow(() -> {
                logger.error("Invalid Product ID for update: {}", request.getId());
                return new RuntimeException("Product ID is invalid");
            });
        productMapper.updateEntity(product, request);
        productRepository.save(product);
        logger.debug("Updated product with ID: {}", product.getID());
        ProductResponseDTO response = productMapper.toResponseDTO(product);
        logger.trace("Exiting updateProduct");
        return response;
    }
}
