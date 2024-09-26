package com.sabortech.sabortech.Recipe;

import java.util.List;
import java.util.UUID;

import com.sabortech.sabortech.Ingredient.IngredientDTO;
import com.sabortech.sabortech.Rating.RatingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private UUID id;
    private String image;
    private String name;
    private int servings;
    private String title;
    private String description;
    private String[] tags;
    private int time;
    private String time_format;
    private RatingDTO rating;
    private List<IngredientDTO> ingredients;
}