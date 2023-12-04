package com.app.infra.adapter.database.application;

import com.app.domain.UserSignUp;
import com.app.domain.gateway.SearchUserGateway;
import com.app.infra.adapter.database.domain.UserCredentialMapper;
import com.app.infra.adapter.database.repository.UserAuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SearchCredential implements SearchUserGateway {

    private final UserAuthRepository repository;

    @Override
    public Mono<UserSignUp> findByEmail(UserSignUp signUp) {
        return repository.findByEmail(signUp.email().getValue())
                .map(UserCredentialMapper::toModel);
    }
}
