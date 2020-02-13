package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validation.*;

import java.util.List;

public class CustomerService {
    private Customer.CustomerBuilder customer;
    private CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new MemoryCustomerRepository();
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    private String capitalizeFirstLetter(String name){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private String capitalizeName(String name){
            return  capitalizeFirstLetter(name);
        }

    private String getFormattedPersonalNumber(String personalNumber){
        return personalNumber.substring(0, 4) + "-" + personalNumber.substring(4);
    }

    private String formatPersonalNumber(Customer customer){
            return getFormattedPersonalNumber(customer.getPersonalNumber());
    }

    public void insertCustomer(Customer customer) {
        Validator validateFirstName = new FirstNameValidator();
        Validator validateLastName = new LastNameValidator();
        Validator validatePersonalNumber = new PersonalNumberValidator();
        Validator validateAge = new AgeValidator();
        validateAge.getProperty(customer.getAge());

        String capitalizedFirstName = (String) validateFirstName.getProperty(customer.getFirstName());
            capitalizedFirstName = capitalizeName(customer.getFirstName());

        String capitalizedLastName = (String) validateLastName.getProperty(customer.getLastName());;
            capitalizedLastName = capitalizeName(customer.getLastName());

        String formattedPersonalNumber = (String) validatePersonalNumber.getProperty(customer.getPersonalNumber());

              formattedPersonalNumber = formatPersonalNumber(customer);


        Customer.CustomerBuilder newestCustomer = new Customer.CustomerBuilder(capitalizedFirstName, capitalizedLastName, formattedPersonalNumber, customer.getAge())
                .withMiddleName(customer.getMiddleName())
                .withCountryCode(customer.getCountryCode())
                .withCity(customer.getCity())
                .withMonthlyIncome(customer.getMonthlyIncome())
                .withEmployer(customer.getEmployer())
                .withGender(customer.getGender())
                .withMaritalStatus(customer.getMaritalStatus());

        customerRepository.insert(newestCustomer.build());
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

}
