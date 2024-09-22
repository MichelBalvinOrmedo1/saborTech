package com.sabortech.sabortech.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabortech.sabortech.User.User;
import com.sabortech.sabortech.User.UserRepository;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<RecipeDTO> getAllRecipe() {
        List<RecipeModel> dataList = recipeRepository.findAll();
        List<RecipeDTO> recipeDTOList = dataList.stream().map(data -> new RecipeDTO(
                data.getId(),
                data.getTitle(),
                data.getDescription(),
                data.getTags(),
                data.getRating())).toList();

        return recipeDTOList;
    }

    public Optional<RecipeModel> getRecipeById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RecipeDTO createRecipe(RecipeRequest request, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        RecipeModel recip = RecipeModel.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .tags(request.getTags())
                .rating(request.getRating())
                .user(user)
                .build();

        RecipeModel savedRecipe = recipeRepository.save(recip);

        // Mapear RecipeModel a RecipeDTO
        RecipeDTO recipeDTO = new RecipeDTO(
                savedRecipe.getId(),
                savedRecipe.getTitle(),
                savedRecipe.getDescription(),
                savedRecipe.getTags(),
                savedRecipe.getRating());
        return recipeDTO;
    }
}
