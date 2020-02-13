package com.enorkus.academy.controller;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    private CustomerService customerService;

    public MainController() {
        this.customerService = new CustomerService();
    }


    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {
        return customerService.fetchCustomers();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }

    @RequestMapping("/cars")
    public List<Car> getCars(){
        List<Car> cars = new ArrayList<>();
       cars.add(new Car("Audi", 100, "red", false, Arrays.asList("Deluxe")));
        cars.add(new Car("Porsche", 44, "red", true, Arrays.asList("Nice")));

        return cars;
    }
    public class Car{
        private String model;
        private int speed;
        private String color;
        private Boolean isFast;
        private List<String> modification;

        public Car(String model, int speed, String color, Boolean isFast, List<String> modification) {
            this.model = model;
            this.speed = speed;
            this.color = color;
            this.isFast = isFast;
            this.modification = modification;
        }

        public String getModel() {
            return model;
        }

        public int getSpeed() {
            return speed;
        }

        public String getColor() {
            return color;
        }

        public Boolean getFast() {
            return isFast;
        }

        public List<String> getModification() {
            return modification;
        }
    }

}