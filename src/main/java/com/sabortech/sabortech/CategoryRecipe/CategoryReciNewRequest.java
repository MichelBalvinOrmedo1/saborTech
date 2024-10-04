package com.sabortech.sabortech.CategoryRecipe;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReciNewRequest {

    @NotEmpty
    @Valid
    private List<CategoryRecipeRequest> categoryRecipes;
}
