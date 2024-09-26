package com.sabortech.sabortech.Rating;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingModel, UUID> {

    RatingModel findRatingByRecipeId(UUID recipeId);

}
