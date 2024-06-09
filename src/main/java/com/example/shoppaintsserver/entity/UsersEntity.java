package com.example.shoppaintsserver.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор", example = "A-124523")
    private Long id;
    @NotBlank()
    @Pattern(regexp = "[A-Z\sa-z]{1,20}")
    @Schema(description = "Логин", example = "Adgsgds")
    private String login;
    @NotBlank()
    @Pattern(regexp = "[A-Z\sa-z0-9]{1,20}")
    @Schema(description = "Пароль", example = "Agdgdgd")
    private String password;
    @NotBlank()
    @Pattern(regexp = "[A-Z\sa-z]{1,20}")
    @Schema(description = "Роль", example = "Agdgdgd")
    private String role;
}
