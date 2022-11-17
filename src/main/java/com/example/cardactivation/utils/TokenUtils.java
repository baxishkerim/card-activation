package com.example.cardactivation.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenUtils {



    public static String getUsernameFromToken(String bearToken,String secret) {

    String token = "";

    //todo what if token = null? check this and add additional condition.
    if (bearToken != null && bearToken.startsWith("Bearer")) {
        token = bearToken.substring(7);
    }
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token);

        return claims.getBody().getSubject();
    }
}
