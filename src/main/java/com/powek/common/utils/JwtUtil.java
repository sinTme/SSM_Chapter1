package com.powek.common.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    public final static String secretKey = "powekjsonwebtokenkey";
    public final static Long maxAge = 1800000L;

    public static String createToken(String id, String accountName)
    {
        Map<String,Object> claimMap = new HashMap<String, Object>();
        claimMap.put("id",id);
        claimMap.put("accountName",accountName);
        String token = Jwts.builder()
                .setClaims(claimMap)
                .setExpiration(new Date(System.currentTimeMillis() + maxAge))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
        return token;
    }

    public static Boolean verifyToken(String token)
    {
        Map<String,Object> claimMap = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        String id  = claimMap.get("id").toString();
        return true;
    }
}
