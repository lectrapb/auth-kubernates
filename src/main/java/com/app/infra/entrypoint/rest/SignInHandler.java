package com.app.infra.entrypoint.rest;


import com.app.application.signIn.SignIn;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class SignInHandler {

    private final Environment env;
    private final SignIn signIn;


    public Mono<ServerResponse> signIn(ServerRequest request) {

        return request.bodyToMono(SignInRequest.class)
                .flatMap(req -> signIn.verifyUser(req.getEmail(), req.getPassword()))
                .flatMap(isValid -> isValid ? ServerResponse.ok().body(Mono.just("Credential allowed"), String.class)
                        : ServerResponse.status(HttpStatus.BAD_REQUEST)
                        .body(null));

    }
}

@Data
class SignInRequest {

    private String email;
    private String password;
}
