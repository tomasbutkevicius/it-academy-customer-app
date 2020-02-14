package com.enorkus.academy.validation;

import com.enorkus.academy.exception.ValidationException;

public class CustomerAdultValidator extends Validator<Integer> {
    @Override
    public void validate(Integer Attribute, String message) {
        if (Attribute < 18) {
            throw new ValidationException(message);
        }
    }
}
