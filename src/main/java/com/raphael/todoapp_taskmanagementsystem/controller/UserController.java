package com.raphael.todoapp_taskmanagementsystem.controller;

import com.raphael.todoapp_taskmanagementsystem.data.model.User;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.LoginRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.SignUpRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.LoginResponse;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.SignUpResponse;

import java.util.List;

public interface UserController {

    public SignUpResponse addUser(SignUpRequest signUpRequest);
    public LoginResponse loginUser(LoginRequest loginRequest);
    public User getUserById(String userId);
    public User getUserByUsername(String username);
    public User getUserByEmail(String email);
    public User getUserPhoneNumber(String phoneNumber);
    public List<User> getAllUser();

    public String updateUser(String userId, String fistName, String lastName, String email, String phoneNumber, String password);

    public String deleteUser(String userId);

}
