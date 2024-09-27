package com.sabortech.sabortech.ApiResponse;

public class ApiPaths {
    public static final String BASE_PATH = "/recipe";
    public static final String RECIPE_BASE_PATH = BASE_PATH + "/{idRecipe}";
    public static final String CATEGORY_PATH = RECIPE_BASE_PATH + "/category";

    public static final String INGREDIENT_PATH = RECIPE_BASE_PATH + "/ingredient";

    public static final String STEP_PATH = RECIPE_BASE_PATH + "/step";
}
