package com.enorkus.academy.validation;

import com.enorkus.academy.exception.ValidationException;
import com.enorkus.academy.types.CountryCode;
import org.apache.commons.lang3.EnumUtils;

public class CountryCodeValidator extends Validator<String>{
    @Override
    public void validate(String Attribute, String message) {
        if( !EnumUtils.isValidEnum(CountryCode.class, Attribute.toUpperCase()) ){
            throw new ValidationException(message);
        }
    }
}
