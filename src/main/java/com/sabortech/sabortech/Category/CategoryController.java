package com.sabortech.sabortech.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabortech.sabortech.ApiResponse.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ApiResponse<List<CategoryDTO>> getAllCategory() {
        List<CategoryDTO> categories = categoryService.getAllCategory();
        return new ApiResponse<>("success", "Categories retrieved", categories);
    }

    @PostMapping
    public ApiResponse<CategoryDTO> createCategory(@Valid @RequestBody CategoryRequest request) {
        return new ApiResponse<>("success", "Category created", categoryService.createCategory(request));
    }

}
