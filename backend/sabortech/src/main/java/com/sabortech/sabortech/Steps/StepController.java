package com.sabortech.sabortech.Steps;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabortech.sabortech.ApiResponse.ApiPaths;
import com.sabortech.sabortech.ApiResponse.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiPaths.STEP_PATH)
public class StepController {

    @Autowired
    private StepService stepService;

    @PostMapping
    public ApiResponse<List<StepDTO>> createStepsEx(@Valid @RequestBody StepNewRequest request,
            @PathVariable UUID idRecipe) {
        List<StepDTO> stepDTOs = stepService.createStep(request.getSteps(), idRecipe);
        return new ApiResponse<>("success", "Steps created", stepDTOs);
    }

}
