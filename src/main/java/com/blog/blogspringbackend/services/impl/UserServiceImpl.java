package com.blog.blogspringbackend.services.impl;

import com.blog.blogspringbackend.entity.User;
import com.blog.blogspringbackend.exceptions.ResourceNotFoundException;
import com.blog.blogspringbackend.payloads.UserDto;
import com.blog.blogspringbackend.repository.UserRepo;
import com.blog.blogspringbackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User savedUser = this.userRepo.save(dtoToUser(userDto));
        return userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()->
                        new ResourceNotFoundException("User","id",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        User savedUser = userRepo.save(user);

        return userToDto(savedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()->
                        new ResourceNotFoundException("User","id",userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(this::userToDto).toList();
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()->
                        new ResourceNotFoundException("User","id",userId));
        this.userRepo.delete(user);
    }

    User dtoToUser(UserDto userDto) {
        return this.modelMapper.map(userDto, User.class);
    }

    UserDto userToDto(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }
}
