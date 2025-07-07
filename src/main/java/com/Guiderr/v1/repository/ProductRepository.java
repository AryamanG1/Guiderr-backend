package com.Guiderr.v1.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Guiderr.v1.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product , UUID> {
	Optional<Product> findProductBySku(String sku);
	List<Product> findByPriceBetween(Long lowerP , Long HigherP);
	List<Product> findByNameContaining(String name);
	List<Product> findProductByBrand(String brand);
}
