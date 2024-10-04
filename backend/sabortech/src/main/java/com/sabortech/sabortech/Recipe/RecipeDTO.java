package com.sabortech.sabortech.Recipe;

import java.util.List;
import java.util.UUID;

import com.sabortech.sabortech.CategoryRecipe.CategoryRecipeDTO;
import com.sabortech.sabortech.Ingredient.IngredientDTO;
import com.sabortech.sabortech.Rating.RatingDTO;
import com.sabortech.sabortech.Steps.StepDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private UUID id;
    private UUID file_id;
    private String name;
    private int servings;
    private String title;
    private String description;
    private String[] tags;
    private int time;
    private String time_format;
    private RatingDTO rating;
    private List<IngredientDTO> ingredients;
    private List<StepDTO> steps;
    private List<CategoryRecipeDTO> categories;
    private String image;
}