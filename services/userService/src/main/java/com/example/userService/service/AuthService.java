package com.example.userService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userService.dto.LoginRequest;
import com.example.userService.dto.RegisterRequest;
import com.example.userService.enity.User;
import com.example.userService.repository.UserRepository;
import com.example.userService.ultils.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER
    public String register(RegisterRequest req) {

        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setEmail(req.getEmail());
        user.setFullName(req.getFullName());
        user.setPhoneNumber(req.getPhoneNumber());
        user.setAddress(req.getAddress());
        user.setCityzenCode(req.getCityzenCode());
        user.setRole("USER"); // default

        userRepository.save(user);

        return "Register success";
    }

    // LOGIN
    public String login(LoginRequest req) {

        User user = userRepository.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return jwtUtil.generateToken(user);
    }
}