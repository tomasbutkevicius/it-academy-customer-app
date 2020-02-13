package com.enorkus.academy.validation;

import com.enorkus.academy.exception.MandatoryValueMissingException;

public class FirstNameValidator implements Validator<String>{
    @Override
    public String getProperty(String key) {
        if (key == null || key.isEmpty()) {
            throw new MandatoryValueMissingException("First name is mandatory!");
        }
        return key;
    }
}
