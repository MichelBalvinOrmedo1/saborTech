package com.sabortech.sabortech.Ingredient;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabortech.sabortech.ApiResponse.ApiPaths;
import com.sabortech.sabortech.ApiResponse.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiPaths.INGREDIENT_PATH)
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public ApiResponse<List<IngredientDTO>> createIngredient(@Valid @RequestBody IngredientNewRequest request,
            @PathVariable UUID idRecipe) {
        List<IngredientDTO> ingredientDTOs = ingredientService.createIngredient(request.getIngredients(), idRecipe);
        return new ApiResponse<>("success", "Ingredient created", ingredientDTOs);
    }

}
