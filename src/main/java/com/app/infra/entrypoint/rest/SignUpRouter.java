package com.app.infra.entrypoint.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SignUpRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(SignUpHandler handler){
        return route().POST("/api/auth/sign-up", handler::signUp)
                .POST("/api/auth/sign-in", handler::signIn)
                .build();
    }
}
