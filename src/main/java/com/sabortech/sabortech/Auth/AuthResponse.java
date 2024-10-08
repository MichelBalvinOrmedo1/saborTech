package com.sabortech.sabortech.Auth;

import com.sabortech.sabortech.Profile.ProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    String token;

    String userName;

    ProfileDTO profile;

}
