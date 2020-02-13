package com.enorkus.academy.validation;

import com.enorkus.academy.exception.MandatoryValueMissingException;

public class PersonalNumberValidator implements Validator<String> {
    @Override
    public String getProperty(String key) {
        if(key == null || key.isEmpty()) {
            throw new MandatoryValueMissingException("Personal number is mandatory!");
            // throw new InvalidParameterException(MessageFormat.format("Missing value in form ", key));
        }
        return key;
    }
}
