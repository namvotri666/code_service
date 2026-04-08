package com.example.apiGateWay.filter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtPresenceFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();

        // Nếu request là /auth/login → cho qua luôn
        if (path.equals("/auth/login")) {
            return chain.filter(exchange);
        }

        // Lấy header Authorization
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");

        // Nếu không có token → trả 401
        if (token == null || token.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Có token → tiếp tục forward request
        return chain.filter(exchange);
    }
}