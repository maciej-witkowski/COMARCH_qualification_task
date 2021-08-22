package com.maciej_witkowski.rental.controller;

import com.maciej_witkowski.rental.model.Customer;
import com.maciej_witkowski.rental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @DeleteMapping(path = "{customerId}")
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("customerId") Long id) {
        return customerService.deleteCustomer(id);
    }

}
