package com.harshit.expense_tracker.dto;


import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String email;
    private String password;
    public LoginRequest(String username,String email,String password)
    {
        this.username=username;
        this.email=email;
        this.password=password;
    }
}
