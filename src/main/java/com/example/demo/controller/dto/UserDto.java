package com.example.demo.controller.dto;

import com.example.demo.domain.entity.Role;


public class UserDto {
    private String email;
    //@NotBlank(message = "Password shouldn't be blank.")
    //@Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z])+)(?=(.*\\d)+)(?=(.*\\W)+)(?!.*\\s).{8,}$",
    // message = "password at least 8 characters and one letter and one number and one character")
    private String password;
    private String firstName;
    private String lastName;
    private Role role;

    public UserDto() {
    }

    public UserDto(String email, String password, String firstName, String lastName, Role role) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
