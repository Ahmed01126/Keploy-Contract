package com.example.orderservice.controller;

import com.example.orderservice.model.dto.OrderDto;
import com.example.orderservice.model.entity.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
    }

    @GetMapping("/get/{id}")
    public OrderDto getOrder(@PathVariable UUID id) {
        return orderService.getOrder(id);
    }

    @PutMapping("/update")
    public void updateOrder(@RequestBody OrderDto orderDto) {
        orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable UUID OrderId) {
        orderService.deleteOrder(OrderId);
    }

    @GetMapping("/get/all")
    public Iterable<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/get/user/{userId}")
    public Iterable<Order> getOrdersByUserId(@PathVariable UUID userId) {
        return orderService.getOrdersByUserId(userId);
    }

}