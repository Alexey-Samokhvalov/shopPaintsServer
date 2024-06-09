package com.example.shoppaintsserver.repository;

import com.example.shoppaintsserver.entity.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepo extends JpaRepository<BasketEntity, Long> {
}
