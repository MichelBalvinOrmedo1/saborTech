package com.sabortech.sabortech.Steps;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepDTO {

    private UUID id;
    private String description;
    private Integer stepNumber;
}
