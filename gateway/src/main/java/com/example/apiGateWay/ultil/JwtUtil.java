package com.example.apiGateWay.ultil;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final Key key = Keys.hmacShaKeyFor(
            "mysecretkeymysecretkeymysdsfajkdfhkaecretkey12djkfahdkafhdjkafhkjdhfkjsdafhakjsdhfbcnvbhadfhakfhdajfhsdafjahfdjhfdjafdkahfjdahf"
                    .getBytes());

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}