package com.sabortech.sabortech.CategoryRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sabortech.sabortech.Category.CategoryDTO;
import com.sabortech.sabortech.Category.CategoryService;

import jakarta.validation.Valid;

@Service
@Validated
public class CategoryRecipeService {

    @Autowired
    private CategoryRecipeRepository categoryRecipeRepository;

    @Autowired
    private CategoryService categoryRepository;

    public List<CategoryRecipeDTO> getCategoryRecipeByRecipeId(UUID recipeId) {
        List<CategoryRecipeDTO> categoryNames = categoryRecipeRepository.findCategoryRecipeByRecipeId(recipeId);

        return categoryNames;
    }

    public List<CategoryRecipeDTO> creaCategoryRecipeDTO(@Valid List<CategoryRecipeRequest> requests, UUID recipeId) {
        List<CategoryRecipeDTO> categoryRecipeDT = new ArrayList<>();

        Integer maxNumberCategory = categoryRecipeRepository.findMaxNumberCategoryByRecipeId(recipeId);
        if (maxNumberCategory == null) {
            maxNumberCategory = 0; // Si no hay registros, inicializar a 0
        }

        for (CategoryRecipeRequest request : requests) {
            maxNumberCategory++; // Incrementar el valor máximo en 1

            CategoryRecipeId categoryRecipeId = new CategoryRecipeId(request.getCategoryId(), recipeId);
            CategoryDTO categoryName = categoryRepository.getCategoryById(request.getCategoryId());

            CategoryRecipeModel categoryRecipeModel = CategoryRecipeModel.builder()
                    .id(categoryRecipeId)
                    .numberCategory(maxNumberCategory)
                    .build();

            CategoryRecipeModel categoryRecipe = categoryRecipeRepository.save(categoryRecipeModel);
            CategoryRecipeDTO categoryRecipeDTO = new CategoryRecipeDTO(
                    categoryRecipe.getId(),
                    categoryRecipe.getId().getRecipeId(),
                    categoryRecipe.getId().getCategoryId(),
                    categoryRecipe.getNumberCategory(),
                    categoryName.getName());

            categoryRecipeDT.add(categoryRecipeDTO);
        }

        return categoryRecipeDT;
    }
}
