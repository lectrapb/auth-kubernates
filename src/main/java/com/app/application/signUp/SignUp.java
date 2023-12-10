package com.app.application.signUp;


import com.app.domain.ConstantBusinessExcep;
import com.app.domain.UserSignUp;
import com.app.domain.gateway.SaveUserGateway;
import com.app.domain.gateway.SearchUserGateway;
import com.app.shared.domain.exception.BusinessException;
import com.app.shared.domain.label.UseCase;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Optional;

@UseCase
@AllArgsConstructor
public class SignUp {

    private final SaveUserGateway saveUserRepository;
    private final SearchUserGateway searchUserRepository;

    public Mono<Void> addUser(String name, String email, String password) {

        return Mono.fromCallable(() -> UserSignUp.instanceOf(name,  email, password))
                .flatMap(searchUserRepository::findByEmail)
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(userOpt -> checkIsPresent(userOpt.isPresent())
                            .thenReturn(UserSignUp.instanceOf(name, email, password)))
                .flatMap(saveUserRepository::save);

    }

    private  Mono<Void> checkIsPresent(boolean isPresent) {
        if (isPresent) {
            throw new BusinessException(ConstantBusinessExcep.CREDENTIAL_IS_PRESENT);
        }
        return Mono.empty();
    }
}
