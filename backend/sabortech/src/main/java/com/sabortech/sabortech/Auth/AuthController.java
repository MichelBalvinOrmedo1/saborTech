package com.sabortech.sabortech.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/register")
    public String register() {
        return "register";
    }

    @GetMapping(value = "/hola")
    public String logout() {
        return "logout";
    }

}
