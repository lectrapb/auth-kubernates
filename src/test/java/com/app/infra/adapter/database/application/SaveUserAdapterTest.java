package com.app.infra.adapter.database.application;

import com.app.domain.UserSignUp;
import com.app.domain.value.Email;
import com.app.domain.value.Name;
import com.app.domain.value.Password;
import com.app.infra.adapter.database.domain.UserCredentialsData;
import com.app.infra.adapter.database.repository.UserAuthRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SaveUserAdapterTest {

    private  UserAuthRepository repository;
    private SaveUserAdapter userAdapter;

    @BeforeEach
    void setUp() {
        repository  = mock(UserAuthRepository.class);
        userAdapter = new SaveUserAdapter(repository);
    }

    @Test
    void save_ok_test() {
        //given
        var user = new UserSignUp(new Name("Jhon"), new Email("jhon@mail.com"),
                new Password("4343545"));
        var response = Mono.just(new UserCredentialsData());
        //when
        when(repository.save(any())).thenReturn(response);
        //then
        userAdapter.save(user)
                .as(StepVerifier::create)
                .expectNextCount(0)
                .verifyComplete(); 
    }


}