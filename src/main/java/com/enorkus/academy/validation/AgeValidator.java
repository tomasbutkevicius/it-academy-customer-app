package com.enorkus.academy.validation;

import com.enorkus.academy.exception.CustomerNotAdultException;
import com.enorkus.academy.exception.MandatoryValueMissingException;

public class AgeValidator{
    public Integer getProperty(Integer key) {
        if (key < 18) {
            throw new CustomerNotAdultException("Customer must be 18 or older!");
        }
        return key;
    }
}
