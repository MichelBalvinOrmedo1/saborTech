package com.sabortech.sabortech.Steps;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StepRequest {

    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Step number is required")
    private Integer stepNumber;
}
