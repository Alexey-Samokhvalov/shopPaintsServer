package com.example.shoppaintsserver.service;

import com.example.shoppaintsserver.entity.ProductEntity;
import com.example.shoppaintsserver.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class ProductService {
    private final ProductRepo repo;

    public List<ProductEntity> findAll() {
        return repo.findAll();
    }

    public Optional<ProductEntity> findById(Long id) {
        return repo.findById(id);
    }
    public ProductEntity save (ProductEntity data) {
        return repo.save(data);
    }

    public void update (ProductEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {repo.deleteById(id);}
}
