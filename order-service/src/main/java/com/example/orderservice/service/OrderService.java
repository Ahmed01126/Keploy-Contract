package com.example.orderservice.service;

import com.example.orderservice.model.dto.OrderDto;
import com.example.orderservice.model.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    void createOrder(OrderDto orderDto);

    OrderDto getOrder(UUID orderId);

    void updateOrder(OrderDto orderDto);

    void deleteOrder(UUID orderId);

    List<Order> getAllOrders();

    List<Order> getOrdersByUserId(UUID userId);

}
