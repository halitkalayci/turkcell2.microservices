package io.github.halitkalayci.security.jwt;

import java.security.Key;
import java.sql.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class BaseJwtService {
    private Long EXPIRATION_TIME = 6000000L;
    private String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970"; // Rastgele bir secret key oluştur. 

    public String generateToken(String username){
        return Jwts.builder()
            .subject(username)
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(getSignKey())
            .compact();
    }

    public Boolean validateToken(String token){
        return Jwts.parser()
            .verifyWith((SecretKey)getSignKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getExpiration()
            .after(new Date(System.currentTimeMillis()));
    }

    public String extractUsername(String token){
        return Jwts.parser()
            .verifyWith((SecretKey)getSignKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

    public List<String> extractRoles(String token){
        return Jwts.parser()
            .verifyWith((SecretKey)getSignKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .get("roles", List.class);
    }

    private Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
