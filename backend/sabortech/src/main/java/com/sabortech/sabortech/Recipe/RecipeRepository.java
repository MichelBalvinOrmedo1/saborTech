package com.sabortech.sabortech.Recipe;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeModel, UUID> {
    List<RecipeModel> findByTitleContainingIgnoreCase(String title);

    List<RecipeModel> findByUserId(UUID userId);

}
