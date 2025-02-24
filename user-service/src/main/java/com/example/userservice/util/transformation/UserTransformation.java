package com.example.userservice.util.transformation;

import java.util.UUID;

import com.example.userservice.model.dto.UserDto;
import com.example.userservice.model.entity.User;

public class UserTransformation {
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getName(),user.getEmail(),user.getPassword());
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
