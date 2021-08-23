package com.maciej_witkowski.rental.service;

import com.maciej_witkowski.rental.model.Customer;
import com.maciej_witkowski.rental.model.Report;
import com.maciej_witkowski.rental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Report> getOrdersReport(Long id, Month month) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isEmpty()) {
            throw new IllegalStateException("Customer with id " + id + " does not exists!");
        }

        return optionalCustomer.get().getOrders().stream().filter(order -> order.getDateOfLoan().getMonth().equals(month)).map(order -> new Report(
                order.getId(),
                order.getProduct().getName(),
                order.getProduct().getBrand(),
                order.getDateOfLoan(),
                order.getDateOfReturn(),
                order.getTotalPrice()
        )).collect(Collectors.toList());
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

    public ResponseEntity<HttpStatus> deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new IllegalStateException("Customer with id " + id + " does not exists!");
        }

        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional
    public ResponseEntity<HttpStatus> updateCustomer(Long id, String firstName, String lastName, String email, String phoneNumber) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Customer with id " + id + " does not exists!")
        );

        if (firstName != null && firstName.length() > 0 && !firstName.equals(customer.getFirstName())) {
            customer.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !lastName.equals(customer.getLastName())) {
            customer.setLastName(lastName);
        }

        if (email != null && email.length() > 0 && !email.equals(customer.getEmail())) {
            if (customerRepository.findCustomerByEmail(email).isPresent()) {
                throw new IllegalStateException("Email is taken!");
            }

            customer.setEmail(email);
        }

        if (phoneNumber != null && phoneNumber.length() > 0 && !phoneNumber.equals(customer.getPhoneNumber())) {
            if (customerRepository.findCustomerByPhoneNumber(phoneNumber).isPresent()) {
                throw new IllegalStateException("Phone number is taken!");
            }

            customer.setPhoneNumber(phoneNumber);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
