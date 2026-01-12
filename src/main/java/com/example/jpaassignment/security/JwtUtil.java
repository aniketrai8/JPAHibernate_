package com.example.jpaassignment.security;

import org.springframework.stereotype.Component;

import java.util.Date;
import io.jsonwetoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;





@Component
public class JwtUtil {

    private final String SECRET = "secret-key-1010";

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssued(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60)) //
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()),SignatureAlgorithm.HS256) //
                .compact();
    }

    public String extractUsername(String token){
        return Jwts.parseBuilder()
                .setSigningKey(SECRET.getBytes()) //
                .build()
                .parseClaimsJws(token) //
                .getBody()
                .getSubject();
    }
}
