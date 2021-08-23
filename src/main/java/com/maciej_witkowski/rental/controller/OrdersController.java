package com.maciej_witkowski.rental.controller;

import com.maciej_witkowski.rental.model.Orders;
import com.maciej_witkowski.rental.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrdersController {

    private final OrdersService orderService;

    @Autowired
    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getOrders() {
        return orderService.getOrders();
    }

}
