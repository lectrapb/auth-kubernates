package com.app.application.signIn;

import com.app.domain.gateway.SearchUserGateway;
import com.app.shared.domain.label.UseCase;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import com.app.domain.UserSignIn;

import java.util.Optional;

@UseCase
@AllArgsConstructor
public class SignIn {


    private final SearchUserGateway searchUserRepository;

    public Mono<Boolean> verifyUser(String email, String password){

        return Mono.fromCallable(() -> UserSignIn.instanceOf(email, password))
                .flatMap(searchUserRepository::findByEmailAndPassword)
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .map(Optional::isPresent);
    }
}
