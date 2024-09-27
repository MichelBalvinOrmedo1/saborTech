package com.sabortech.sabortech.Ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 2, message = "Description must be at least 2 characters long")
    private String name;

    @NotBlank(message = "Amount is mandatory")
    @Size(min = 2, message = "Description must be at least 2 characters long")
    private String amount;

    @NotBlank(message = "Unit is mandatory")
    private String unit;
}