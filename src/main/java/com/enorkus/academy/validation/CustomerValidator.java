package com.enorkus.academy.validation;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.CustomerNotAdultException;
import com.enorkus.academy.exception.InvalidCountryCodeException;
import com.enorkus.academy.exception.MandatoryValueMissingException;
import com.enorkus.academy.types.CountryCode;
import org.apache.commons.lang3.EnumUtils;

public class CustomerValidator {


    public void validateCustomer(Customer customer){
        validateMandatoryValues(customer.getFirstName(),customer.getLastName(),customer.getPersonalNumber());
        validateAge(customer.getAge());

        if(customer.getCountryCode() != null && !customer.getCountryCode().isEmpty())
            validateCountryCode(customer.getCountryCode());
    }


    private void validateMandatoryValues(String firstName, String lastName, String personalNumber){
        if (firstName == null || firstName.isEmpty()) {
        throw new MandatoryValueMissingException("First name is mandatory!");
    } else if (lastName == null || lastName.isEmpty()) {
        throw new MandatoryValueMissingException("Last name is mandatory!");
    }else if (personalNumber == null || personalNumber.isEmpty()) {
        throw new MandatoryValueMissingException("Personal number is mandatory!");
    }}


    private void validateAge(int age){
        if (age < 18) {
            throw new CustomerNotAdultException("Customer must be 18 or older!");
        }
    }


    private void validateCountryCode(String countryCode){
        if( !EnumUtils.isValidEnum(CountryCode.class, countryCode.toUpperCase()) ){
            throw new InvalidCountryCodeException("Invalid country code!");
        }
    }
    private void validateMandatoryValue(){}
}
