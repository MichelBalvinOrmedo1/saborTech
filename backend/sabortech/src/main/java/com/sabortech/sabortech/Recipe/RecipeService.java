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
import com.sabortech.sabortech.File.FileService;
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

    @Autowired
    private FileService fileService;

    public Optional<RecipeModel> getRecipeById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<RecipeDTO> getAllRecipe() {
        List<RecipeModel> dataList = recipeRepository.findAll();

        List<RecipeDTO> recipeDTOList = dataList.stream().map(recipe -> {
            RatingDTO rating = ratingService.getRating(recipe.getId());
            List<IngredientDTO> ingredients = ingredientService.getIngredientsByRecipeId(recipe.getId());
            List<StepDTO> steps = stepService.getStepsByRecipeId(recipe.getId());
            List<CategoryRecipeDTO> categories = categoryRecipeService.getCategoryRecipeByRecipeId(recipe.getId());

            String profileImage = fileService.getFilePath(recipe.getFile_id());
            return RecipeDTO.builder()
                    .id(recipe.getId())
                    .file_id(recipe.getFile_id())
                    .name(recipe.getName())
                    .servings(recipe.getServings())
                    .title(recipe.getTitle())
                    .description(recipe.getDescription())
                    .tags(recipe.getTags())
                    .time(recipe.getTime())
                    .time_format(recipe.getTime_format())
                    .rating(rating)
                    .ingredients(ingredients)
                    .steps(steps)
                    .categories(categories)
                    .image(profileImage)
                    .build();

        }).collect(Collectors.toList());

        return recipeDTOList;
    }

    public RecipeDTO createRecipe(@Valid RecipeRequest request, UUID userId) {

        RecipeModel recip = RecipeModel.builder()
                .file_id(request.getFile_id())
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
        String profileImage = fileService.getFilePath(recip.getFile_id());

        return RecipeDTO.builder()
                .id(recip.getId())
                .file_id(recip.getFile_id())
                .name(recip.getName())
                .servings(recip.getServings())
                .title(recip.getTitle())
                .description(recip.getDescription())
                .tags(recip.getTags())
                .time(recip.getTime())
                .time_format(recip.getTime_format())
                .rating(rating)
                .ingredients(ingredients)
                .steps(steps)
                .categories(categories)
                .image(profileImage)
                .build();

    }
}
