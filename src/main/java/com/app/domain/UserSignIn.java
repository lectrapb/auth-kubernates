package com.app.domain;

import com.app.domain.value.Email;
import com.app.domain.value.Password;

public record UserSignIn(Email email, Password password) {

     public static UserSignIn instanceOf(String email, String password){
         return new UserSignIn(new Email(email), new Password(password));
     }
}
