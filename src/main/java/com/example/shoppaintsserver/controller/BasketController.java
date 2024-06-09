package com.example.shoppaintsserver.controller;

import com.example.shoppaintsserver.entity.BasketEntity;
import com.example.shoppaintsserver.entity.ProductEntity;
import com.example.shoppaintsserver.response.BaseResponse;
import com.example.shoppaintsserver.response.ListResponse;
import com.example.shoppaintsserver.service.BasketService;
import com.example.shoppaintsserver.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/basket")
@AllArgsConstructor
@Tag(name="Корзина", description="Взаимодействие с корзиной")
public class BasketController {
    private final BasketService service;
    @GetMapping("/all")
    @Operation(
            summary = "Просмотреть всех товары"
    )
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<BasketEntity>(true, "Список товаров", service.findAll()));
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