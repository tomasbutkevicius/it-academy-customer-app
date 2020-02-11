package com.enorkus.academy.validation;

import com.enorkus.academy.entity.Customer;

public class PersonValidator implements Validator {

    @Override
    public boolean validateUserInformation(String firstName, String lastName, String personalNumber) {
        if(firstName == null || lastName == null || personalNumber == null)
            return false;
        else
            return true;
    }
}
