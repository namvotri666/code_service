package com.example.userService.ultils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.userService.enity.User;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysdsfajkdfhkaecretkey12djkfahdkafhdjkafhkjdhfkjsdafhakjsdhfbcnvbhadfhakfhdajfhsdafjahfdjhfdjafdkahfjdahf";

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}