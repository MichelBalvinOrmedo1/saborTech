package com.sabortech.sabortech.Rating;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public RatingDTO createRating(UUID recipeId, BigDecimal ratingValue, UUID userId) {

        RatingModel rating = RatingModel.builder()
                .rating(ratingValue)
                .recipeId(recipeId)
                .userId(userId)

                .build();

        // Guardar la calificación en el repositorio
        rating = ratingRepository.save(rating);

        // Crear y devolver el DTO de la calificación
        return new RatingDTO(
                rating.getId(),
                rating.getRating());
    }

    public RatingDTO getRating(UUID idRecipe) {
        RatingModel rating = ratingRepository.findRatingByRecipeId(idRecipe);

        RatingDTO ratingDT = new RatingDTO(
                rating.getId(),
                rating.getRating());

        return ratingDT;
    }

}
