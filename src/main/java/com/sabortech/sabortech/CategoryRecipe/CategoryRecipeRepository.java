package com.sabortech.sabortech.CategoryRecipe;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRecipeRepository extends JpaRepository<CategoryRecipeModel, CategoryRecipeId> {

    @Query("SELECT MAX(c.numberCategory) FROM CategoryRecipeModel c WHERE c.recipeId = :recipeId")
    Integer findMaxNumberCategoryByRecipeId(@Param("recipeId") UUID recipeId);

    @Query("SELECT new com.sabortech.sabortech.CategoryRecipe.CategoryRecipeDTO(cr.id, cr.recipeId, cr.categoryId, cr.numberCategory, c.name) "
            +
            "FROM CategoryRecipeModel cr JOIN cr.category c WHERE cr.recipeId = :recipeId")
    List<CategoryRecipeDTO> findCategoryRecipeByRecipeId(@Param("recipeId") UUID recipeId);
}
