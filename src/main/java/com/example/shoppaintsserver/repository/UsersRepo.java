package com.example.shoppaintsserver.repository;

import com.example.shoppaintsserver.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<UsersEntity, Long> {
}
