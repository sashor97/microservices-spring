package com.microservices.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer=Customer.builder().firstName(customerRequest.getFirstName()).lastName(customerRequest.getLastName()).email(customerRequest.getEmail()).build();
        //todo: check if email valid
        //todo: check if email not taken
        //todo: store customer in db
        customerRepository.save(customer);
    }
}
