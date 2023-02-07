package com.raphael.todoapp_taskmanagementsystem.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;
    @Email
    private String email;
    private Address address;

    @OneToMany(cascade = CascadeType.ALL) // This means that if we delete a user, we also delete its todos
    private List<Todo> todoList = new ArrayList<>();

    public User(String firstName, String lastName, String userName, String password, String phoneNumber, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
