package com.sabortech.sabortech.Profile;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabortech.sabortech.exception.ProfileNotFoundException;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public ProfileDTO getProfileByUserId(UUID userId) {
        ProfileModel profileModel = profileRepository.findProfileByUserId(userId);

        if (profileModel == null) {
            throw new ProfileNotFoundException("Profile not found");
        }

        return new ProfileDTO(profileModel.getId(), profileModel.getFirstName(), profileModel.getLastName(),
                profileModel.getEmail(), profileModel.getRecipesCount(), profileModel.getFollowersCount(),
                profileModel.getBiografy(), profileModel.getProfileImage());
    }

    public ProfileDTO getProfileById(UUID id) {
        ProfileModel profileModel = profileRepository.findProfileById(id);

        if (profileModel == null) {
            throw new ProfileNotFoundException("Profile not found ");
        }

        return new ProfileDTO(profileModel.getId(), profileModel.getFirstName(), profileModel.getLastName(),
                profileModel.getEmail(), profileModel.getRecipesCount(), profileModel.getFollowersCount(),
                profileModel.getBiografy(), profileModel.getProfileImage());
    }

    public ProfileDTO createProfile(ProfileRequest profileRequest, UUID userId) {

        String biografy = profileRequest.getBiografy();
        if (biografy == null) {
            biografy = "";
        }

        ProfileModel profileModel = ProfileModel.builder()
                .firstName(profileRequest.getFirstName())
                .lastName(profileRequest.getLastName())
                .email(profileRequest.getEmail())
                .recipesCount(0)
                .followersCount(0)
                .biografy(biografy)
                .profileImage(profileRequest.getProfileImage())
                .userId(userId)
                .build();

        ProfileModel savedProfile = profileRepository.save(profileModel);

        return new ProfileDTO(savedProfile.getId(), savedProfile.getFirstName(), savedProfile.getLastName(),
                savedProfile.getEmail(), savedProfile.getRecipesCount(), savedProfile.getFollowersCount(),
                savedProfile.getBiografy(), savedProfile.getProfileImage());
    }

    // update recipesCount
    public int updateRecipesCount(UUID profileId) {
        ProfileModel profileModel = profileRepository.findProfileByUserId(profileId);

        if (profileModel == null) {
            throw new ProfileNotFoundException("Profile not found");
        }

        int updatedRecipesCount = profileModel.getRecipesCount() + 1;
        profileModel.setRecipesCount(updatedRecipesCount);
        profileRepository.save(profileModel);

        return updatedRecipesCount;
    }
}
