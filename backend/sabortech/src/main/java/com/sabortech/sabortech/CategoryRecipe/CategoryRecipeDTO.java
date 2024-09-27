package com.sabortech.sabortech.CategoryRecipe;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRecipeDTO {

    private CategoryRecipeId id;
    private UUID recipeId;
    private UUID categoryId;
    private Integer numberCategory;
    private String categoryName;
}
