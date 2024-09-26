package com.sabortech.sabortech.Ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class IngredientRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Amount is mandatory")
    private int amount;

    @NotBlank(message = "Unit is mandatory")
    private String unit;
}