package com.example.shoppaintsserver.service;

import com.example.shoppaintsserver.entity.ReviewsEntity;
import com.example.shoppaintsserver.repository.ReviewsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;
@Service
@AllArgsConstructor
@Validated
public class ReviewsService { private final ReviewsRepo repo;

    public List<ReviewsEntity> findAll() {
        return repo.findAll();
    }

    public ReviewsEntity save (ReviewsEntity data) {
        return repo.save(data);
    }


    public void delete (Long id) {repo.deleteById(id);}

}
