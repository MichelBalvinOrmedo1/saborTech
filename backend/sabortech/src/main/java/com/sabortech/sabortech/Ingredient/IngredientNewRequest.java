package com.sabortech.sabortech.Ingredient;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class IngredientNewRequest {

    @NotEmpty
    @Valid
    private List<IngredientRequest> ingredients;
}
