package com.example.shoppaintsserver.repository;

import com.example.shoppaintsserver.entity.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepo extends JpaRepository<ReviewsEntity, Long> {
}
