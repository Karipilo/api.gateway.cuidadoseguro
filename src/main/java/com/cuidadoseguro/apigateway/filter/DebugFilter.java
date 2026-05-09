package com.cuidadoseguro.apigateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class DebugFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {

        String auth = exchange.getRequest().getHeaders().getFirst("Authorization");

        //System.out.println("GATEWAY RECIBE: " + auth);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    public DebugFilter() {
        //System.out.println("DEBUG FILTER CONSTRUCTOR");
    }
}