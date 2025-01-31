package com.study.inventory.repository;

import com.study.inventory.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
}
