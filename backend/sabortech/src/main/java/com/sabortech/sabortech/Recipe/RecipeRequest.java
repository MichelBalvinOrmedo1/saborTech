package com.sabortech.sabortech.Recipe;

import java.util.List;

import com.sabortech.sabortech.Ingredient.IngredientRequest;

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
    @NotNull
    String image;
    @NotNull
    String name;
    @NotNull
    int servings;

    @NotEmpty(message = "Ingredients cannot be empty")
    @Valid
    List<IngredientRequest> ingredients;

}