package com.maciej_witkowski.rental.controller;

import com.maciej_witkowski.rental.model.Customer;
import com.maciej_witkowski.rental.model.Orders;
import com.maciej_witkowski.rental.model.Report;
import com.maciej_witkowski.rental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
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

    @GetMapping(path = "{customerId}/orders")
    public List<Report> getOrdersReport(
            @PathVariable("customerId") Long id,
            @RequestParam() Month month
    ) {
        return customerService.getOrdersReport(id, month);
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

    @PutMapping(path = "{customerId}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateCustomer(
            @PathVariable("customerId") Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phoneNumber
    ) {
        return customerService.updateCustomer(id, firstName, lastName, email, phoneNumber);
    }

}
