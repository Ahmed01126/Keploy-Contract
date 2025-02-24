package com.example.userservice.service;

import java.util.UUID;

import com.example.userservice.model.dto.UserDto;
import com.example.userservice.model.entity.User;

public interface UserService {

    void createUser(UserDto userDto);

    UserDto getUser(UUID id);

    void updateUser(UserDto userDto);

    void deleteUser(UUID userId);

    Iterable<User> getAllUsers();

    void deleteUserByEmail(String email);
}