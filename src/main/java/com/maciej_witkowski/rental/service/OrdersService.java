package com.maciej_witkowski.rental.service;

import com.maciej_witkowski.rental.dto.OrdersDTO;
import com.maciej_witkowski.rental.model.Customer;
import com.maciej_witkowski.rental.model.Orders;
import com.maciej_witkowski.rental.model.Product;
import com.maciej_witkowski.rental.repository.CustomerRepository;
import com.maciej_witkowski.rental.repository.OrdersRepository;
import com.maciej_witkowski.rental.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Orders registerOrder(OrdersDTO order) {

        Optional<Customer> optionalCustomer = customerRepository.findById(order.getCustomerId());
        Optional<Product> optionalProduct = productRepository.findById(order.getProductId());

        if (optionalCustomer.isEmpty() || optionalProduct.isEmpty()) {
            throw new IllegalStateException("Given customer id or product id does not exists!");
        }

        Orders received = new Orders(
                optionalCustomer.get(),
                optionalProduct.get(),
                order.getDateOfLoan(),
                order.getDateOfReturn()
        );

        System.out.println(received);

        ordersRepository.save(received);
        return received;
    }

}
