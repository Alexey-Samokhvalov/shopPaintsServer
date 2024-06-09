package com.example.shoppaintsserver.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор", example = "A-124523")
    private Long id;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,100}")
    @Schema(description = "Наименование", example = "Виаичм Авуаыуа Ваыааы")
    private String name;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,100}")
    @Schema(description = "Бренд", example = "Виаичм Авуаыуа Ваыааы")
    private String brand;
    @NotBlank()
    @Pattern(regexp = "[А-Я\sа-я]{1,100}")
    @Schema(description = "Цвет", example = "Виаичм")
    private String color;
    @NotBlank()
    @Pattern(regexp = "[0-9.]{1,100}")
    @Schema(description = "Цена", example = "1.000.000")
    private String price;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "basket_id")
    @Schema(description = "Корзина", example = "A-124523")
    private BasketEntity basket;
}
