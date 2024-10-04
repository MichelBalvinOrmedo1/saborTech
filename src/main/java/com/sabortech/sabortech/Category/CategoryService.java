package com.sabortech.sabortech.Category;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO getCategoryById(UUID id) {
        CategoryModel category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return new CategoryDTO(
                category.getId(),
                category.getName());
    }

    public List<CategoryDTO> getAllCategory() {
        List<CategoryModel> category = categoryRepository.findAll();

        List<CategoryDTO> categoryDTO = category.stream().map(categori -> {
            return new CategoryDTO(
                    categori.getId(),
                    categori.getName());
        }).collect(Collectors.toList());

        return categoryDTO;
    }

    public CategoryDTO createCategory(CategoryRequest request) {
        CategoryModel category = CategoryModel.builder()
                .name(request.getName())
                .build();

        CategoryModel categoryModel = categoryRepository.save(category);

        return new CategoryDTO(
                categoryModel.getId(),
                categoryModel.getName());
    }

}
