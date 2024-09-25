package com.sabortech.sabortech.Recipe;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabortech.sabortech.User.UserRepository;

import jakarta.validation.Valid;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<RecipeModel> getRecipeById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<RecipeDTO> getAllRecipe() {
        List<RecipeModel> dataList = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOList = dataList.stream().map(recipe -> new RecipeDTO(
                recipe.getId(),
                recipe.getImage(), // Asegúrate de que RecipeModel tenga este campo
                recipe.getName(), // Asegúrate de que RecipeModel tenga este campo
                recipe.getServings(), // Asegúrate de que RecipeModel tenga este campo
                recipe.getTitle(),
                recipe.getDescription(),
                Arrays.asList(recipe.getTags()), // Convert String[] to List<String>
                recipe.getTime(), // Asegúrate de que RecipeModel tenga este campo
                recipe.getTime_format() // Asegúrate de que RecipeModel tenga este campo
        )).collect(Collectors.toList());

        return recipeDTOList;
    }

    public RecipeDTO createRecipe(@Valid RecipeRequest request, UUID userId) {

        RecipeModel recip = RecipeModel.builder()
                .image(request.getImage())
                .name(request.getName())
                .servings(request.getServings())
                .time(request.getTime())
                .time_format(request.getTime_format())
                .description(request.getDescription())
                .tags(request.getTags().toArray(String[]::new))
                .userId(userId)
                .build();

        recip = recipeRepository.save(recip);
        return new RecipeDTO(
                recip.getId(),
                recip.getImage(),
                recip.getName(),
                recip.getServings(),
                recip.getTitle(),
                recip.getDescription(),
                Arrays.asList(recip.getTags()),
                recip.getTime(),
                recip.getTime_format());
    }
}
