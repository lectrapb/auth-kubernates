package com.app.infra.adapter.database.repository;

import com.app.infra.adapter.database.domain.UserCredentialsData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


public interface UserAuthRepository extends ReactiveCrudRepository<UserCredentialsData, String> {

    Mono<UserCredentialsData> findByEmail(String email);
}
