package com.sabortech.sabortech.CategoryRecipe;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CategoryRecipeId implements Serializable {
    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "recipe_id")
    private UUID recipeId;
}
