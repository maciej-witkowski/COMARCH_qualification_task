package com.maciej_witkowski.rental.controller;

import com.maciej_witkowski.rental.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrdersController {

    private final OrdersService orderService;

    @Autowired
    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;
    }

}
