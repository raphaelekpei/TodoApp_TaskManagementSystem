package com.raphael.todoapp_taskmanagementsystem.service;

import com.raphael.todoapp_taskmanagementsystem.data.model.Address;
import com.raphael.todoapp_taskmanagementsystem.data.model.User;
import com.raphael.todoapp_taskmanagementsystem.data.repository.UserRepository;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.LoginRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.request.SignUpRequest;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.LoginResponse;
import com.raphael.todoapp_taskmanagementsystem.dtos.response.SignUpResponse;
import com.raphael.todoapp_taskmanagementsystem.exceptions.UserManagementException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SignUpResponse addUser(SignUpRequest signUpRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(signUpRequest.getEmail());
        if (optionalUser.isPresent()){
            throw new UserManagementException("user with the email " + signUpRequest.getEmail() + " email  already exist");
        }
        User user = new User(
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getPassword(),
                signUpRequest.getEmail(),
                signUpRequest.getPhoneNumber(),
                signUpRequest.getUserName(),
                signUpRequest.getAddress()
        );
        userRepository.save(user);
        SignUpResponse signUpResponse = new SignUpResponse();
        signUpResponse.setMessage("Registration was successful");
        return signUpResponse;
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());
        if (optionalUser.isEmpty()){
            throw new UserManagementException("email or password incorrect");
        }
        User user = optionalUser.get();
        if (user.getPassword().equals(loginRequest.getPassword())){
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage("you have successfully logged in");
            return loginResponse;
        }
        throw new UserManagementException("email or password incorrect");
    }

    @Override
    public User getUserById(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        return optionalUser.get();
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        return optionalUser.get();
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        Optional<User> optionalUser = userRepository.findByPhoneNumber(phoneNumber);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        return optionalUser.get();
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(String userId, String fistName, String lastName, String email, String phoneNumber, String password, Address address) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        User user = optionalUser.get();
        if (fistName != null){
            user.setFirstName(fistName);
        }
        if (lastName != null){
            user.setLastName(lastName);
        }
        if (email != null){
            user.setPhoneNumber(phoneNumber);
        }
        if (password != null){
            user.setPassword(password);
        }
        if (address != null){
            user.setAddress(address);
        }
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user not found");
        }
        User user = optionalUser.get();
        userRepository.delete(user);
    }
}
