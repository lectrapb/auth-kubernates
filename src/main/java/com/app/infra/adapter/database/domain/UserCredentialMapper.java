package com.app.infra.adapter.database.domain;

import com.app.domain.UserSignUp;

public final class UserCredentialMapper {

    private UserCredentialMapper() {}

    public static UserCredentialsData  toData(UserSignUp userSignUp){

        var credentials  = new UserCredentialsData();
        credentials.setName(userSignUp.name().getValue());
        credentials.setEmail(userSignUp.email().getValue());
        credentials.setPassword(userSignUp.password().getValue());
        return credentials;
    }

    public static UserSignUp toModel(UserCredentialsData credentialsData){

        return  UserSignUp.instanceOf(credentialsData.getName(),
                credentialsData.getEmail(),
                credentialsData.getPassword());
    }
}
