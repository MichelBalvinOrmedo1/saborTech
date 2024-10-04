package com.sabortech.sabortech.CategoryRecipe;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRecipeRequest {

    @NotNull(message = "Category id is required")
    private UUID categoryId;

}
