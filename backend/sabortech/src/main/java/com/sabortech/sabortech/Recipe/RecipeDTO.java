package com.sabortech.sabortech.Recipe;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private UUID id;
    private String title;
    private String description;
    private String tags;
    private BigDecimal rating;

    // Constructor, getters y setters

    // Getters y setters
}