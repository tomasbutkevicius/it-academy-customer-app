package com.enorkus.academy.validation;

import com.enorkus.academy.entity.Customer;

public interface Validator {
    boolean validateUserInformation(String firstName, String lastName, String personalNumber);
}
