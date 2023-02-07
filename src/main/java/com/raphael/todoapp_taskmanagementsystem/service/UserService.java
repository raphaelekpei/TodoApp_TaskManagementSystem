package com.raphael.todoapp_taskmanagementsystem.service;

import com.raphael.todoapp_taskmanagementsystem.data.model.Address;
import com.raphael.todoapp_taskmanagementsystem.data.model.User;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.LoginRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.SignUpRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.LoginResponse;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.SignUpResponse;

import java.util.List;

public interface UserService {

    SignUpResponse addUser(SignUpRequest signUpRequest);

    LoginResponse loginUser(LoginRequest loginRequest);

    User getUserById(String userId);

    User getUserByEmail(String email);

    User getUserByPhoneNumber(String phoneNumber);

    User getUserByUsername(String username);
    List<User> getAllUser();

    void updateUser(String userId, String fistName, String lastName, String email, String phoneNumber, String password, Address address);

    void deleteUser(String userId);
}
