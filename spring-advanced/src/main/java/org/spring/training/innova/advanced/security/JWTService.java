package org.spring.training.innova.advanced.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.KeyStore;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private Key key;

    public JWTService() {
        this.key = Keys.hmacShaKeyFor("JsonWebTokenDenemeYanilmaFalanFilan".getBytes());
    }

    public String generateToken(UserDetails user,
                                String ip) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("ip",
                   ip);
        String compact = Jwts.builder()
                             .setSubject(user.getUsername())
                             .setIssuedAt(new Date())
                             .setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
                             .addClaims(claims)
                             .signWith(key)
                             .compact();
        return compact;
    }

    public Jws<Claims> check(String token) {
        JwtParser jwtParser = Jwts.parserBuilder()
                                  .setSigningKey(key)
                                  .build();
        Jws<Claims> claimsJws = null;
        try {
            claimsJws = jwtParser.parseClaimsJws(token);
            return claimsJws;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
