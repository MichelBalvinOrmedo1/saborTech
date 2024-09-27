package com.sabortech.sabortech.CategoryRecipe;

import java.util.UUID;

import com.sabortech.sabortech.Category.CategoryModel;
import com.sabortech.sabortech.Recipe.RecipeModel;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "category_recipe")
public class CategoryRecipeModel {

    @EmbeddedId
    private CategoryRecipeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false, insertable = false, updatable = false)
    private RecipeModel recipe;

    @Column(name = "recipe_id", nullable = false, insertable = false, updatable = false)
    private UUID recipeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false)
    private CategoryModel category;

    @Column(name = "category_id", nullable = false, insertable = false, updatable = false)
    private UUID categoryId;

    @Column(nullable = false)
    private Integer numberCategory;

}