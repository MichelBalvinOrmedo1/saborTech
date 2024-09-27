package com.sabortech.sabortech.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @PostMapping
    public CategoryDTO createCategory(@Valid @RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }

}
