package com.exam.shoppinglist.model.service;

import com.exam.shoppinglist.model.entity.BaseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserServiceModel extends BaseEntity {

    private String username;
    private String password;
    private String email;

    public UserServiceModel() {
    }

    @NotBlank(message = "Username can not be null or empty")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Password can not be null or empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters ")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Email(message = "Email not valid")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
