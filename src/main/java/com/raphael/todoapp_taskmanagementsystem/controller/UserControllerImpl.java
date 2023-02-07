package com.raphael.todoapp_taskmanagementsystem.controller;

import com.raphael.todoapp_taskmanagementsystem.data.model.Address;
import com.raphael.todoapp_taskmanagementsystem.data.model.User;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.LoginRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.SignUpRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.LoginResponse;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.SignUpResponse;
import com.raphael.todoapp_taskmanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserControllerImpl implements UserController{
    @Autowired
    private final UserService userService;


    @Override
    @PostMapping("/signup")
    public SignUpResponse addUser(SignUpRequest signUpRequest) {
        return userService.addUser(signUpRequest);
    }

    @Override
    @PostMapping("/login")
    public LoginResponse loginUser(LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }

    @Override
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @Override
    @GetMapping("/user/username")
    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @Override
    @GetMapping("/user/email")
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    @GetMapping("/user/phone-number")
    public User getUserPhoneNumber(String phoneNumber) {
        return userService.getUserByPhoneNumber(phoneNumber);
    }

    @Override
    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @Override
    @PutMapping("/update/{userId}")
    public String updateUser(
            @PathVariable String userId,
            @RequestParam String fistName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String password) {
        userService.updateUser(userId, fistName, lastName, email, phoneNumber, password, new Address());
        return "successfully updated";
    }

    @Override
    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "successfully deleted";
    }
}
