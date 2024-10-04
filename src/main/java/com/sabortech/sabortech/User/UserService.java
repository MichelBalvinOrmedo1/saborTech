package com.sabortech.sabortech.User;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sabortech.sabortech.jwt.JwtService;

@Service
public class UserService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    public UUID getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            if (userDetails instanceof User user) {
                return user.getId();
            }
        }
        return null; // o lanza una excepción si prefieres
    }

    public UUID getAuthenticatedUserId(String token) {
        String username = jwtService.getUsernameFromToken(token);
        // Aquí puedes buscar el usuario en la base de datos usando el nombre de usuario
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return user.getId();
        }

        return null; // o lanza una excepción si prefieres
    }
}