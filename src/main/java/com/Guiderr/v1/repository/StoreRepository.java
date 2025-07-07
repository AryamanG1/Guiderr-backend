package com.Guiderr.v1.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Guiderr.v1.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,UUID> {
	Optional<Store> findByName(String name);
}
