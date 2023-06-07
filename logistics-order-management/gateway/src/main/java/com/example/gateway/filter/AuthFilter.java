package com.example.gateway.filter;

import com.example.common.constant.CommonConstant;
import com.example.common.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 认证过滤器
 * @author: Lumos
 * @date: 2023-05-21
 */
//@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {


    @Value("#{'${auth.exclude.pattern}'.split(',')}")
    private List<String> excludePatternList;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        HttpHeaders headers = request.getHeaders();
        String authorization = headers.getFirst(CommonConstant.AUTH_HEADER);
        String path = request.getPath().pathWithinApplication().value();
        // 过滤
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String pattern : excludePatternList) {
            if (pathMatcher.match(pattern, path)) {
                return chain.filter(exchange);
            }
        }
        // 没有设置认证请求头
        if (authorization == null) {
            response.setStatusCode(HttpStatus.FORBIDDEN);
            return response.setComplete();
        }
        String token = null;
        if (authorization.startsWith(CommonConstant.AUTH_TOKEN_PREFIX)) {
            token = authorization.substring(CommonConstant.AUTH_TOKEN_PREFIX.length());
        } else {
            // token格式错误
            response.setStatusCode(HttpStatus.BAD_REQUEST);
            return response.setComplete();
        }
        Mono<Boolean> mono = Mono.just(JwtUtil.verify(token));
        return mono.flatMap((result) -> {
            if (result) {
                return chain.filter(exchange);
            } else {
                // 没有权限
                response.setStatusCode(HttpStatus.FORBIDDEN);
                return response.setComplete();
            }
        });
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
