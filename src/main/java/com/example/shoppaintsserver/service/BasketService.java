package com.example.shoppaintsserver.service;

import com.example.shoppaintsserver.entity.BasketEntity;
import com.example.shoppaintsserver.repository.BasketRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Validated
public class BasketService {
    private final BasketRepo repo;

    public List<BasketEntity> findAll() {
        return repo.findAll();
    }

    public void delete (Long id) {
        repo.deleteById(id);}
}
