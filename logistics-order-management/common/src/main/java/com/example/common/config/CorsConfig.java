package com.example.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域访问
 * @author: Lumos
 * @date: 2023-05-21
 */
@Component
@ConditionalOnProperty(value = "common.cors", havingValue = "true", matchIfMissing = false)
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedMethods("POST","GET","OPTIONS","DELETE","PUT")
                .maxAge(16000)
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
