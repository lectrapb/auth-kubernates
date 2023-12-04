package com.app.shared.domain.value;

import com.app.domain.ConstantBusinessExcep;
import com.app.shared.domain.exception.SystemException;

public abstract class ValidateWord {

    private final String value;

    public ValidateWord(String value) {
        if(value == null || value.isEmpty()){
            throw new SystemException(ConstantBusinessExcep.DATA_IS_REQUIRED);
        }
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
