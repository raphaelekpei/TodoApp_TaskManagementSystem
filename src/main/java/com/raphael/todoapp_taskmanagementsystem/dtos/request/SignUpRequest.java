package com.raphael.todoapp_taskmanagementsystem.dtos.request;

import com.raphael.todoapp_taskmanagementsystem.data.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String email;
    private Address address;
    private String userName;

}
