package com.example.shoppaintsserver.controller;

import com.example.shoppaintsserver.entity.ProductEntity;
import com.example.shoppaintsserver.response.BaseResponse;
import com.example.shoppaintsserver.response.DataResponse;
import com.example.shoppaintsserver.response.ListResponse;
import com.example.shoppaintsserver.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@AllArgsConstructor
@Tag(name="Товар", description="Взаимодействие с товарами")
public class ProductController {
    private final ProductService service;

    @GetMapping("/all")
    @Operation(
            summary = "Просмотреть всех товары"
    )
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ProductEntity>(true, "Список товаров", service.findAll()));
    }

    @GetMapping
    @Operation(
            summary = "Поиск товара по id"
    )
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<ProductEntity>(true, "Найден следующий товар", service.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping
    @Operation(
            summary = "Добавить товар"
    )
    public ResponseEntity<BaseResponse> save(@RequestBody ProductEntity product) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<ProductEntity>(true, "Товар сохранен", service.save(product)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping
    @Operation(
            summary = "Обновить товар"
    )
    public ResponseEntity<BaseResponse> update(@RequestBody ProductEntity product) {
        try {
            service.update(product);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Товар сохранен"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/delete")
    @Operation(
            summary = "Удалить товар"
    )
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {

        service.delete(id);
        return ResponseEntity.ok(new BaseResponse(true, "Товар удален"));

    }
}
