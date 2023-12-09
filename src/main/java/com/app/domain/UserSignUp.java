package com.app.domain;

import com.app.domain.value.Email;
import com.app.domain.value.Name;
import com.app.domain.value.Password;

public record UserSignUp(Name name, Email email, Password password) {

    public static UserSignUp instanceOf(String name, String email, String password){
        return new UserSignUp(new Name(name), new Email(email), new Password(password));
    }


}
