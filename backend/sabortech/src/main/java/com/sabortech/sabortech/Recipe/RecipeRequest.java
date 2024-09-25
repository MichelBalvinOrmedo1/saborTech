package com.sabortech.sabortech.Recipe;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class RecipeRequest {

    @NotBlank(message = "Title is mandatory")
    String title;

    @NotBlank(message = "Description is mandatory")
    String description;

    List<String> tags;

    @NotNull(message = "Time is mandatory")
    int time;

    @NotBlank(message = "Time format is mandatory")
    String time_format;
    @NotNull
    String image;
    @NotNull
    String name;
    @NotNull
    int servings;

    public RecipeRequest(String title, String description, List<String> tags, int time, String time_format,
            String image, String name, int servings) {
        this.title = title;
        this.description = description;
        this.tags = (tags != null) ? tags : new ArrayList<>();
        this.time = time;
        this.time_format = time_format;
        this.image = image;
        this.name = name;
        this.servings = servings;
    }
}