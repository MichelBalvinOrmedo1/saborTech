package com.sabortech.sabortech.Recipe;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabortech.sabortech.CategoryRecipe.CategoryRecipeDTO;
import com.sabortech.sabortech.CategoryRecipe.CategoryRecipeService;
import com.sabortech.sabortech.Ingredient.IngredientDTO;
import com.sabortech.sabortech.Ingredient.IngredientService;
import com.sabortech.sabortech.Profile.ProfileService;
import com.sabortech.sabortech.Rating.RatingDTO;
import com.sabortech.sabortech.Rating.RatingService;
import com.sabortech.sabortech.Steps.StepDTO;
import com.sabortech.sabortech.Steps.StepService;

import jakarta.validation.Valid;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private StepService stepService;

    @Autowired
    private CategoryRecipeService categoryRecipeService;

    @Autowired
    private ProfileService profileService;

    public Optional<RecipeModel> getRecipeById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<RecipeDTO> getAllRecipe() {
        List<RecipeModel> dataList = recipeRepository.findAll();

        List<RecipeDTO> recipeDTOList = dataList.stream().map(recipe -> {
            RatingDTO ratting = ratingService.getRating(recipe.getId());
            List<IngredientDTO> ingredients = ingredientService.getIngredientsByRecipeId(recipe.getId());
            List<StepDTO> steps = stepService.getStepsByRecipeId(recipe.getId());
            List<CategoryRecipeDTO> categories = categoryRecipeService.getCategoryRecipeByRecipeId(recipe.getId());
            return new RecipeDTO(
                    recipe.getId(),
                    recipe.getImage(),
                    recipe.getName(),
                    recipe.getServings(),
                    recipe.getTitle(),
                    recipe.getDescription(),
                    recipe.getTags(),
                    recipe.getTime(),
                    recipe.getTime_format(),
                    ratting,
                    ingredients,
                    steps,
                    categories);
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

        List<IngredientDTO> ingredients = ingredientService.createIngredient(request.ingredients, recip.getId());

        List<StepDTO> steps = stepService.createStep(request.steps, recip.getId());

        List<CategoryRecipeDTO> categories = categoryRecipeService.creaCategoryRecipeDTO(request.categories,
                recip.getId());

        profileService.updateRecipesCount(userId);

        return new RecipeDTO(
                recip.getId(),
                recip.getImage(),
                recip.getName(),
                recip.getServings(),
                recip.getTitle(),
                recip.getDescription(),
                recip.getTags(),
                recip.getTime(),
                recip.getTime_format(),
                rating,
                ingredients,
                steps,
                categories);

    }
}
