package com.example.orderservice.util.transformation;

import com.example.orderservice.model.dto.OrderDto;
import com.example.orderservice.model.entity.Order;

import java.util.Optional;
import java.util.UUID;

public class OrderTransformation {
    public static OrderDto toOrderDto(Optional<Order> order) {
        return new OrderDto(order.getId(), order.getUserId(),
                            order.getProductName(), order.getQuantity(), order.getPrice());
    }

    public static Order toOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setPrice(orderDto.getPrice());
        order.setProductName(orderDto.getProductName());
        order.setQuantity(orderDto.getQuantity());
        order.setUserId(orderDto.getUserId());
        return order;
    }
}
