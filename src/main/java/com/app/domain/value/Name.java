package com.app.domain.value;

import com.app.shared.domain.value.ValidateWord;
import lombok.Getter;

@Getter
public class Name extends ValidateWord {


    public Name(String value) {
        super(value);
    }


}
