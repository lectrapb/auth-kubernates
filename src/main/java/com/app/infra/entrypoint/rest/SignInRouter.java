package com.app.infra.entrypoint.rest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SignInRouter {

    @Bean
    public RouterFunction<ServerResponse> router(SignInHandler handler){
          return route(POST("/api/auth/signIn"),handler::signIn );
    }
}
