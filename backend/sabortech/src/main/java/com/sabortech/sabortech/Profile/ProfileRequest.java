package com.sabortech.sabortech.Profile;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class ProfileRequest {

    @NotBlank(message = "First name is required")
    @Size(min = 3, message = "First name must be at least 3 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, message = "Last name must be at least 3 characters")
    private String lastName;

    @NotBlank(message = "Username is required")
    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "Recipes count is required")
    private Integer recipesCount;

    @NotNull(message = "Followers count is required")
    private Integer followersCount;

    private String biografy;

    private String profileImage;

}
