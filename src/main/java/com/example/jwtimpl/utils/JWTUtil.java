package com.example.jwtimpl.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    private static  final String SIGN_MARK = "boboluya";

    public static String getToken(Map<String ,String> map){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND,60);
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SIGN_MARK));
    }

    public static void verify(String token){
        JWT.require(Algorithm.HMAC256(SIGN_MARK)).build().verify(token);
    }

    public static Map<String,String> userMap(String token){
        Map<String, Claim> claims = JWT.require(Algorithm.HMAC256(SIGN_MARK)).build().verify(token).getClaims();
        Map<String,String> map = new HashMap<>();
        claims.forEach((k,v)->map.put(k,v.asString()));
        return map;
    }
}
