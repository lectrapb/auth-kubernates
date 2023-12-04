package com.app.infra.adapter.database.application;

import com.app.domain.UserSignUp;
import com.app.domain.gateway.SaveUserGateway;
import static com.app.infra.adapter.database.domain.UserCredentialMapper.toData;
import com.app.infra.adapter.database.domain.UserCredentialsData;
import com.app.infra.adapter.database.repository.UserAuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SaveUserAdapter implements SaveUserGateway {

    private final UserAuthRepository repository;
    @Override
    public Mono<Void> save(UserSignUp userSignUp) {

        return   repository.save(toData(userSignUp))
                .flatMap(userCredentialsData -> Mono.empty());
    }
}
