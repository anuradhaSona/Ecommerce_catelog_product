package com.ecom.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.app.entity.ProductCountEntity;
import com.ecom.app.entity.ProductEntity;

public interface ProductCountRepository extends JpaRepository<ProductCountEntity, Integer> {

	public Optional<ProductCountEntity> findByProduct(ProductEntity product);
}
