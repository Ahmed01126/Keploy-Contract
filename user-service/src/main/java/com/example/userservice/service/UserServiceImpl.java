package com.example.userservice.service;

import com.example.userservice.model.dto.UserDto;
import com.example.userservice.model.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.util.transformation.UserTransformation;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDto userDto) {
        userRepository.save(UserTransformation.toUser(userDto));
    }

    @Override
    public UserDto getUser(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserTransformation::toUserDto).orElse(null);
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepository.save(UserTransformation.toUser(userDto));
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
