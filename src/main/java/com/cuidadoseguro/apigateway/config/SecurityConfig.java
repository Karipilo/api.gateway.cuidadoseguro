package com.cuidadoseguro.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)

                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(
                                "/auth/login",
                                "/auth/register",
                                "/auth/validate",
                                "/auth/refresh",
                                "/auth/logout",
                                "/auth/health",
                                "/pacientes/**",
                                "/pacientes/",
                                "/rabbit/**",
                                "/rabbit/",
                                "/controles/**",
                                "/controles/",
                                "/evoluciones/**",
                                "/evoluciones/",
                                "/examenes/**",
                                "/examenes/",                                
                                "/fichas/**",
                                "/fichas",
                                "/indicaciones/**",
                                "/indicaciones",
                                "/medicamentos/**",
                                "/medicamentos",
                                "/signos-vitales/**",
                                "/signos-vitales"
                        ).permitAll()

                        .anyExchange().authenticated()
                )

                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)

                .build();
    }
}