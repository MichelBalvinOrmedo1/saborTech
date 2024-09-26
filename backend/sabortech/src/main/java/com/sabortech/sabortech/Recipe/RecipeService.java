package com.sabortech.sabortech.Recipe;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabortech.sabortech.Rating.RatingDTO;
import com.sabortech.sabortech.Rating.RatingService;

import jakarta.validation.Valid;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RatingService ratingService;

    public Optional<RecipeModel> getRecipeById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<RecipeDTO> getAllRecipe() {
        List<RecipeModel> dataList = recipeRepository.findAll();

        List<RecipeDTO> recipeDTOList = dataList.stream().map(recipe -> {
            RatingDTO ratting = ratingService.getRating(recipe.getId());

            return new RecipeDTO(
                    recipe.getId(), // Convertir String a UUID
                    recipe.getImage(),
                    recipe.getName(),
                    recipe.getServings(),
                    recipe.getTitle(),
                    recipe.getDescription(),
                    recipe.getTags(),
                    recipe.getTime(),
                    recipe.getTime_format(), // Asegúrate de tener el método getTimeFormat
                    ratting // Asegúrate de que rating esté correctamente definido y accesible
            );
        }).collect(Collectors.toList());

        return recipeDTOList;
    }

    public RecipeDTO createRecipe(@Valid RecipeRequest request, UUID userId) {

        RecipeModel recip = RecipeModel.builder()
                .image(request.getImage())
                .name(request.getName())
                .title(request.getTitle())
                .servings(request.getServings())
                .time(request.getTime())
                .time_format(request.getTime_format())
                .description(request.getDescription())
                .tags(request.getTags().toArray(String[]::new))
                .userId(userId)
                .build();

        recip = recipeRepository.save(recip);

        BigDecimal ratingValue = new BigDecimal(0);
        RatingDTO rating = ratingService.createRating(recip.getId(), ratingValue, userId);

        return new RecipeDTO(
                recip.getId(),
                recip.getImage(),
                recip.getName(),
                recip.getServings(),
                recip.getTitle(),
                recip.getDescription(),
                recip.getTags(), // Convert List<String> to String[]
                recip.getTime(),
                recip.getTime_format(),
                rating);
    }
}
