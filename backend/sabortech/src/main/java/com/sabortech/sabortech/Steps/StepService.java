package com.sabortech.sabortech.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService {

    @Autowired
    private StepRepository stepRepository;

    public List<StepDTO> getStepsByRecipeId(UUID recipeId) {
        List<StepModel> stepModels = stepRepository.findStepByRecipeId(recipeId);
        List<StepDTO> stepDTOs = new ArrayList<>();

        for (StepModel stepModel : stepModels) {
            StepDTO stepDTO = new StepDTO(
                    stepModel.getId(),
                    stepModel.getDescription(),
                    stepModel.getStepNumber());

            stepDTOs.add(stepDTO);
        }

        return stepDTOs;
    }

    public List<StepDTO> createStep(List<StepRequest> requests, UUID recipeId) {
        List<StepDTO> stepDTOs = new ArrayList<>();

        for (StepRequest request : requests) {
            StepModel stepModel = StepModel.builder()
                    .description(request.getDescription())
                    .stepNumber(request.getStepNumber())
                    .recipeId(recipeId)
                    .build();

            StepModel step = stepRepository.save(stepModel);

            StepDTO stepDTO = new StepDTO(
                    step.getId(),
                    step.getDescription(),
                    step.getStepNumber());

            stepDTOs.add(stepDTO);
        }

        return stepDTOs;
    }
}
