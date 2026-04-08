package com.example.ticket_service.ultils;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.util.Date;
import java.util.function.Function;

@Component
public class JWTUtil {

    private final String SECRET = "mysecretkeymysecretkeymysdsfajkdfhkaecretkey12djkfahdkafhdjkafhkjdhfkjsdafhakjsdhfbcnvbhadfhakfhdajfhsdafjahfdjhfdjafdkahfjdahf"; // ⚠️
                                                                                                                                                                     // phải
                                                                                                                                                                     // giống
                                                                                                                                                                     // bên
                                                                                                                                                                     // UserService
    // 🔹 Extract all claims

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    // 🔹 Extract username (sub)
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 🔹 Extract role
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // 🔹 Extract expiration
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // 🔹 Generic extract
    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        final Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    // 🔹 Check expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // 🔹 Validate token (KHÔNG cần UserDetails nữa)
    public boolean validateToken(String token) {
        try {
            return !isTokenExpired(token);
        } catch (ExpiredJwtException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {

            // token sai → trả về false
            return false;
        }
    }

}