package com.sabortech.sabortech.Category;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {

    CategoryModel findCategoryById(UUID id);
}
