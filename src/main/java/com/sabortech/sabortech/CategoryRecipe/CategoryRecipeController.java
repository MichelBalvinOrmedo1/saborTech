package com.sabortech.sabortech.CategoryRecipe;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabortech.sabortech.ApiResponse.ApiPaths;
import com.sabortech.sabortech.ApiResponse.ApiResponse;

import jakarta.validation.Valid;

@RestController

@RequestMapping(ApiPaths.CATEGORY_PATH)
@Validated
public class CategoryRecipeController {

    @Autowired
    private CategoryRecipeService categoryRecipeService;

    @PostMapping
    public ApiResponse<List<CategoryRecipeDTO>> createCategoryRe(@PathVariable UUID idRecipe,
            @Valid CategoryReciNewRequest entity) {

        List<CategoryRecipeDTO> newCategoryRecipe = categoryRecipeService
                .creaCategoryRecipeDTO(entity.getCategoryRecipes(), idRecipe);
        return new ApiResponse<>("success", "Category Recipe created", newCategoryRecipe);
    }

}
