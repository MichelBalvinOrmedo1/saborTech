package com.sabortech.sabortech.Recipe;

import java.util.List;
import java.util.UUID;

import com.sabortech.sabortech.CategoryRecipe.CategoryRecipeRequest;
import com.sabortech.sabortech.Ingredient.IngredientRequest;
import com.sabortech.sabortech.Steps.StepRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RecipeRequest {

    @NotBlank(message = "Title is mandatory")
    String title;

    @NotBlank(message = "Description is mandatory")
    String description;

    List<String> tags;

    @NotNull(message = "Time is mandatory")
    int time;

    @NotBlank(message = "Time format is mandatory")
    String time_format;
    String image;
    @NotNull
    String name;
    @NotNull
    int servings;

    @NotEmpty(message = "Ingredients cannot be empty")
    @Valid
    List<IngredientRequest> ingredients;

    @NotEmpty(message = "steps cannot be empty")
    @Valid
    List<StepRequest> steps;

    @NotEmpty(message = "categories cannot be empty")
    @Valid
    List<CategoryRecipeRequest> categories;

    @NotNull
    UUID file_id;

}