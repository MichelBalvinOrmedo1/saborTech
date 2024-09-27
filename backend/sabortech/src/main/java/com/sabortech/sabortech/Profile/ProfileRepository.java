package com.sabortech.sabortech.Profile;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileModel, UUID> {

    ProfileModel findProfileById(UUID id);

    ProfileModel findProfileByUserId(UUID userId);
}
