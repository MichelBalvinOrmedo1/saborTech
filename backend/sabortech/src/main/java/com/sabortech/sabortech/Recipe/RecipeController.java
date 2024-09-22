package com.sabortech.sabortech.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabortech.sabortech.User.UserService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<RecipeDTO> getAllRecipe() {
        return recipeService.getAllRecipe();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RecipeModel> getRecipeById(@PathVariable UUID id) {
        Optional<RecipeModel> recipe = recipeService.getRecipeById(id);

        return recipe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeRequest request) {
        UUID userId = userService.getAuthenticatedUserId();

        RecipeDTO newRecipe = recipeService.createRecipe(request, userId);
        return ResponseEntity.ok(newRecipe);
    }

}
