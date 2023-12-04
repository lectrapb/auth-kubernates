package com.app.domain.gateway;

import com.app.domain.UserSignUp;
import reactor.core.publisher.Mono;

public interface SearchUserGateway {

    Mono<UserSignUp> findByEmail(UserSignUp signUp);
}
