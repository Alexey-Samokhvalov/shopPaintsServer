package com.example.shoppaintsserver.controller;

import com.example.shoppaintsserver.entity.UsersEntity;
import com.example.shoppaintsserver.response.BaseResponse;
import com.example.shoppaintsserver.response.DataResponse;
import com.example.shoppaintsserver.response.ListResponse;
import com.example.shoppaintsserver.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
@Tag(name="Пользователи", description="Взаимодействие с пользователями")
public class UsersController {
    private final UsersService service;

    @GetMapping("/all")
    @Operation(
            summary = "Просмотреть всех пользователей"
    )
    public ResponseEntity<ListResponse<UsersEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<UsersEntity>(true, "Список пользователей", service.findAll()));
    }

    @PostMapping
    @Operation(
            summary = "Добавить пользователя"
    )
    public ResponseEntity<DataResponse<UsersEntity>> save(@RequestBody UsersEntity users) {
        return ResponseEntity.ok(
                new DataResponse<UsersEntity>(true, "Пользователь сохранен", service.save(users)));
    }

    @PutMapping("/update")
    @Operation(
            summary = "Обновить пользователя"
    )
    public ResponseEntity<BaseResponse> update(@RequestBody UsersEntity user) {
        service.update(user);
        return ResponseEntity.ok(
                new BaseResponse(true, "Пользователь сохранен"));
    }

}
