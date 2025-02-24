package com.example.orderservice.model.dto;

import com.example.userservice.model.dto.UserDto;
import com.example.userservice.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private UUID userId;
    private String productName;
    private Integer quantity;
    private Double price;
}
