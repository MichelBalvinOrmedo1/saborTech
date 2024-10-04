package com.sabortech.sabortech.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<IngredientDTO> getIngredientsByRecipeId(UUID recipeId) {
        List<IngredientModel> ingredientModels = ingredientRepository.findIngredientByRecipeId(recipeId);
        List<IngredientDTO> ingredientDTOs = new ArrayList<>();

        for (IngredientModel ingredientModel : ingredientModels) {
            IngredientDTO ingredientDTO = new IngredientDTO(
                    ingredientModel.getId(),
                    ingredientModel.getName(),
                    ingredientModel.getAmount(),
                    ingredientModel.getUnit());

            ingredientDTOs.add(ingredientDTO);
        }

        return ingredientDTOs;
    }

    public List<IngredientDTO> createIngredient(@Valid List<IngredientRequest> requests, UUID recipeId) {
        List<IngredientDTO> ingredientDTOs = new ArrayList<>();

        for (IngredientRequest request : requests) {
            IngredientModel ingredientModel = IngredientModel.builder()
                    .name(request.getName())
                    .amount(request.getAmount())
                    .unit(request.getUnit())
                    .recipeId(recipeId)
                    .build();

            IngredientModel ingre = ingredientRepository.save(ingredientModel);

            IngredientDTO ingredientDTO = new IngredientDTO(
                    ingre.getId(),
                    ingre.getName(),
                    ingre.getAmount(),
                    ingre.getUnit());

            ingredientDTOs.add(ingredientDTO);
        }

        return ingredientDTOs;
    }
}
