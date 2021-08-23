package com.maciej_witkowski.rental.service;

import com.maciej_witkowski.rental.model.Orders;
import com.maciej_witkowski.rental.repository.CustomerRepository;
import com.maciej_witkowski.rental.repository.OrdersRepository;
import com.maciej_witkowski.rental.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public List<Orders> getOrders() {
        return ordersRepository.findAll();
    }

}
