package com.enorkus.academy.validation;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.types.CountryCode;
import org.apache.commons.lang3.EnumUtils;

public class CustomerValidator {
    private Validator validator;

    public void validateCustomer(Customer customer){
        validateMandatoryValues(customer.getFirstName(),customer.getLastName(),customer.getPersonalNumber());
        validateAge(customer.getAge());

        if(customer.getCountryCode() != null && !customer.getCountryCode().isEmpty())
            validateCountryCode(customer.getCountryCode());
    }


    private void validateMandatoryValues(String firstName, String lastName, String personalNumber){
        validator = new MandatoryValueValidator();

        validator.validate(firstName,"First name is mandatory!");

        validator.validate(lastName,"Last name is mandatory!");

        validator.validate(personalNumber,"Personal number is mandatory!");
    }


    private void validateAge(int age){
        validator = new CustomerAdultValidator();
        validator.validate(age, "Customer must be 18 or older!");
    }


    private void validateCountryCode(String countryCode){
        validator = new CountryCodeValidator();
        validator.validate(countryCode,  "Invalid country code!");
    }
}
