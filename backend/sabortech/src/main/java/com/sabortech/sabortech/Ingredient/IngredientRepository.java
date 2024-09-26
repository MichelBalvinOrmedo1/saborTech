package com.sabortech.sabortech.Ingredient;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientModel, UUID> {
    List<IngredientModel> findIngredientByRecipeId(UUID recipeId);
}
