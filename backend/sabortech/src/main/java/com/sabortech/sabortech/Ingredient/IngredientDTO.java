package com.sabortech.sabortech.Ingredient;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private UUID id;
    private String name;
    private int amount;
    private String unit;

}
