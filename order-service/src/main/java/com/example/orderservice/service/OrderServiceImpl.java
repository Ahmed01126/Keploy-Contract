package com.example.orderservice.service;

import com.example.orderservice.model.dto.OrderDto;
import com.example.orderservice.model.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.util.transformation.OrderTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        orderRepository.save(OrderTransformation.toOrder(orderDto));
    }

    @Override
    public OrderDto getOrder(UUID orderId) {
        return OrderTransformation.toOrderDto(orderRepository.findById(orderId));
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        orderRepository.save(OrderTransformation.toOrder(orderDto));
    }

    @Override
    public void deleteOrder(UUID orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUserId(UUID userId) {
        return orderRepository.findByUserId(userId);
    }
}
