package com.Guiderr.v1.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Guiderr.v1.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,UUID> {
	List<Store> findByNameContaining(String name);
}
