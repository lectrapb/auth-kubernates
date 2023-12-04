package com.app.application.signUp;

import com.app.domain.UserSignUp;
import com.app.domain.gateway.SaveUserGateway;
import com.app.domain.gateway.SearchUserGateway;
import com.app.domain.value.Email;
import com.app.domain.value.Name;
import com.app.domain.value.Password;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import com.app.domain.ConstantBusinessExcep;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SignUpTest {

    private SaveUserGateway saveUserRepository;
    private SearchUserGateway searchUserRepository;
    private SignUp useCase;
    @BeforeEach
    void setUp() {
        saveUserRepository = mock(SaveUserGateway.class);
        searchUserRepository = mock(SearchUserGateway.class);
        useCase = new SignUp(saveUserRepository, searchUserRepository);
    }

    @Test
    void addUser_null_request_exception_test() {
        //given
        String name = null;
        String email = null;
        String password = null;
        //when
        useCase.addUser(name, email, password)
                .as(StepVerifier::create)
                .expectErrorMessage(ConstantBusinessExcep.DATA_IS_REQUIRED)
                .verify();
        //then
    }

    @Test
    void addUser_is_present_exception_test() {
        //given
        var name = "Jhon";
        var email = "jhon@mail.com";
        var password = "123434";
        var userSignUp = new UserSignUp(new Name(name), new Email(email), new Password(password));
        //when
        when(searchUserRepository.findByEmail(any())).thenReturn(Mono.just(userSignUp));
        //then
        useCase.addUser(name, email, password)
                .as(StepVerifier::create)
                .expectErrorMessage(ConstantBusinessExcep.CREDENTIAL_IS_PRESENT)
                .verify();
    }

    @Test
    void addUser_ok_test() {
        //given
        var name = "Jhon";
        var email = "jhon@mail.com";
        var password = "123434";
        //when
        when(searchUserRepository.findByEmail(any())).thenReturn(Mono.empty());
        when(saveUserRepository.save(any())).thenReturn(Mono.empty());
        //then
        useCase.addUser(name, email, password)
                .as(StepVerifier::create)
                .expectNextCount(0)
                .verifyComplete();
    }
}