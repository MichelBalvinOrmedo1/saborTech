package com.sabortech.sabortech.Recipe;

import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecipeDTO {
    private UUID id;
    private String image;
    private String name;
    private int servings;
    private String title;
    private String description;
    private String[] tags;
    private int time;
    private String time_format;

    // Constructor adicional para manejar tags opcionales
    public RecipeDTO(UUID id, String image, String name, int servings, String title, String description,
            List<String> tags, int time, String time_format) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.servings = servings;
        this.title = title;
        this.description = description;
        this.tags = (tags != null) ? tags.toArray(String[]::new) : new String[0];
        this.time = time;
        this.time_format = time_format;
    }
}