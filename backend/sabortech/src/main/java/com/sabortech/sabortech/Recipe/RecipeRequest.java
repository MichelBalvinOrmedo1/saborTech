package com.sabortech.sabortech.Recipe;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequest {

    String title;
    String description;
    String tags;
    BigDecimal rating;

}
