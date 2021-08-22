package com.maciej_witkowski.rental.service;

import com.maciej_witkowski.rental.model.Customer;
import com.maciej_witkowski.rental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer registerCustomer(Customer customer) {
        if (customerRepository.findCustomerByEmailAndPhoneNumber(customer.getEmail(), customer.getPhoneNumber()).isPresent()) {
            throw new IllegalStateException("Given email and phone number already exists!");
        } else if (customerRepository.findCustomerByEmail(customer.getEmail()).isPresent()) {
            throw new IllegalStateException("Email is taken!");
        } else if (customerRepository.findCustomerByPhoneNumber(customer.getPhoneNumber()).isPresent()) {
            throw new IllegalStateException("Phone number is taken!");
        }

        customerRepository.save(customer);
        return customer;
    }

}
