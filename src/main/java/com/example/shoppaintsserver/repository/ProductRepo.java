package com.example.shoppaintsserver.repository;

import com.example.shoppaintsserver.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
}
