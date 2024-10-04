package com.sabortech.sabortech.Auth;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sabortech.sabortech.Profile.ProfileDTO;
import com.sabortech.sabortech.Profile.ProfileService;
import com.sabortech.sabortech.User.Role;
import com.sabortech.sabortech.User.User;
import com.sabortech.sabortech.User.UserRepository;
import com.sabortech.sabortech.User.UserService;
import com.sabortech.sabortech.exception.UserNotFoundException;
import com.sabortech.sabortech.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

        private final UserRepository userRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;
        @Autowired
        private final ProfileService profileService;
        @Autowired
        private final UserService userService;

        public AuthResponse login(LoginRequest request) {
                try {
                        authenticationManager.authenticate(
                                        new UsernamePasswordAuthenticationToken(request.getUsername(),
                                                        request.getPassword()));
                } catch (Exception e) {
                        throw new UserNotFoundException("Invalid username or password");
                }

                UserDetails user = userRepository.findByUsername(request.getUsername())
                                .orElseThrow(() -> new RuntimeException("User not found"));

                String token = jwtService.getToken(user);

                UUID userId = userService.getAuthenticatedUserId(token);

                ProfileDTO profile = profileService.getProfileByUserId(userId);

                return AuthResponse.builder()
                                .token(token)
                                .userName(user.getUsername())
                                .profile(profile)
                                .build();
        }

        public AuthResponse register(RegisterRequest request) {
                User user = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER)
                                .build();

                User data = userRepository.save(user);

                ProfileDTO profileD = profileService.createProfile(request.getProfile(), data.getId());

                return AuthResponse.builder()
                                .token(jwtService.getToken(user))
                                .profile(profileD)
                                .build();

        }

}