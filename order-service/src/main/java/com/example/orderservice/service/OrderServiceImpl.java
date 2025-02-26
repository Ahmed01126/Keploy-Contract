package com.example.orderservice.service;

import com.example.orderservice.model.dto.OrderDto;
import com.example.orderservice.model.dto.UserDto;
import com.example.orderservice.model.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.util.transformation.OrderTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        // Fetch user details from UserService
        UUID userId = orderDto.getUserId();
        String userServiceUrl = "http://localhost:8081/users/get/" + userId;
        UserDto userDto = restTemplate.getForObject(userServiceUrl, UserDto.class);

        if (userDto == null) {
            throw new RuntimeException("User not found");
        }

        orderRepository.save(OrderTransformation.toOrder(orderDto));
    }

    @Override
    public OrderDto getOrder(UUID orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return OrderTransformation.toOrderDto(order);
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
