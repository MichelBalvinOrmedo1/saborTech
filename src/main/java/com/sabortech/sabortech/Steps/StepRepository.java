package com.sabortech.sabortech.Steps;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<StepModel, UUID> {

    List<StepModel> findStepByRecipeId(UUID recipeId);

}
