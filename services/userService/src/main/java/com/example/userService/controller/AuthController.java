package com.example.userService.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userService.dto.LoginRequest;
import com.example.userService.dto.RegisterRequest;
import com.example.userService.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegisterRequest req) {
        return Map.of("message", authService.register(req));
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest req) {
        System.out.println("Login request: " + req.getUsername());
        return Map.of("token", authService.login(req));
    }
}