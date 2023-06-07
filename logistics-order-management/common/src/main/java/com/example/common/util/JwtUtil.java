package com.example.common.util;

import cn.hutool.jwt.JWT;

/**
 * JWT工具类
 * @author: Lumos
 * @date: 2023/5/27 11:38
 */
public class JwtUtil {

    private static final String secret = "xxx";

    public static String create(String role) {
        return JWT.create()
                .setPayload("role", role)
                .setKey(secret.getBytes())
                .sign();
    }

    public static String getRole(String token) {
        return String.valueOf(JWT.of(token).getPayload("role"));
    }


    public static boolean verify(String token) {
        return JWT.of(token).setKey(secret.getBytes()).verify();
    }
}
