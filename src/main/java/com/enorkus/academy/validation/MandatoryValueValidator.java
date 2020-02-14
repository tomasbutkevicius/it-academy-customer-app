package com.enorkus.academy.validation;

import com.enorkus.academy.exception.ValidationException;

public class MandatoryValueValidator extends Validator<String> {
    @Override
    public void validate(String Attribute, String message) {
        if (Attribute == null || Attribute.isEmpty()) {
            throw new ValidationException(message);
        }
    }
}