package com.Guiderr.v1.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Guiderr.v1.model.StoreInventory;
import com.Guiderr.v1.model.StoreInventoryKey;

@Repository
public interface StoreInventoryRepository extends JpaRepository<StoreInventory,StoreInventoryKey> {
	List<StoreInventory> findByID_StoreID(UUID storeId);
	List<StoreInventory> findByID_ProductID(UUID productId);
}
