package com.app.infra.entrypoint.rest;


import com.app.application.signUp.SignUp;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SignUpHandler {


    private final Environment env;

    private final SignUp signUp;

    public Mono<ServerResponse> signUp(ServerRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("podinfo", env.getProperty("MY_POD_NAME"));
        body.put("podId", env.getProperty("MY_POD_IP"));
        body.put("texto", env.getProperty("config.text"));

        return request.bodyToMono(SignUpRequest.class)
                .flatMap(requestData -> signUp.addUser(requestData.getName(),
                        requestData.getEmail(),
                        requestData.getPassword()))
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(voidOptional -> ServerResponse
                        .status(HttpStatus.CREATED)
                            .body(Mono.just(body), Map.class))
                .onErrorResume(throwable -> ServerResponse
                        .status(HttpStatus.BAD_REQUEST)
                        .body(Mono.just(throwable.getMessage()), String.class) );

    }
}

@Data
class SignUpRequest {

    private String name;
    private String email;
    private String password;
}
