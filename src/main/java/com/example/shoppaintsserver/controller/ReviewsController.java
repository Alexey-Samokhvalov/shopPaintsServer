package com.example.shoppaintsserver.controller;

import com.example.shoppaintsserver.entity.ProductEntity;
import com.example.shoppaintsserver.entity.ReviewsEntity;
import com.example.shoppaintsserver.response.BaseResponse;
import com.example.shoppaintsserver.response.DataResponse;
import com.example.shoppaintsserver.response.ListResponse;
import com.example.shoppaintsserver.service.ProductService;
import com.example.shoppaintsserver.service.ReviewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reviews")
@AllArgsConstructor
@Tag(name="Отзывы", description="Взаимодействие с отзывами")
public class ReviewsController {
    private final ReviewsService service;

    @GetMapping("/all")
    @Operation(
            summary = "Просмотреть всех отзывы"
    )
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ReviewsEntity>(true, "Список отзывов", service.findAll()));
    }

    @PostMapping
    @Operation(
            summary = "Добавить отзыв"
    )
    public ResponseEntity<BaseResponse> save(@RequestBody ReviewsEntity product) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<ReviewsEntity>(true, "Отзыв сохранен", service.save(product)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }


    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить отзыв"
    )
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {

        service.delete(id);
        return ResponseEntity.ok(new BaseResponse(true, "Отзыв удален"));

    }
}
