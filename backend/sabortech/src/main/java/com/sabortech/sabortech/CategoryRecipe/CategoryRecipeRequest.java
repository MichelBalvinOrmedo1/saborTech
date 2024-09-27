package com.sabortech.sabortech.CategoryRecipe;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRecipeRequest {

    @NonNull
    private UUID categoryId;

}
