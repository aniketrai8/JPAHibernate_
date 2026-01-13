package com.example.jpaassignment.security;

import org.springframework.stereotype.Component;

import java.util.Date;




@Component
public class JwtUtil {

    private final String SECRET = "secret-key-1010";

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssued(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60)) //expiry-time of the token
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()),SignatureAlgorithm.HS256) //signs the key to prevent forgery
                .compact();
    }

    public String extractUsername(String token){
        return Jwts.parseBuilder()
                .setSigningKey(SECRET.getBytes()) //
                .build()
                .parseClaimsJws(token) //claims are a part of the payload, these are statement about an entity
                .getBody()
                .getSubject();
    }
}
