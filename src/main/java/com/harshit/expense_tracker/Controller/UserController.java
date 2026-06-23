package com.harshit.expense_tracker.Controller;


import com.harshit.expense_tracker.Model.User;
import com.harshit.expense_tracker.Service.JwtService;
import com.harshit.expense_tracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public User register(@RequestBody User user)
    {
        return service.saveUser(user);
    }

    @GetMapping("/loginn")
    public String loginn(@RequestBody User user)
    {
        System.out.println("username" +user.getUsername());
        System.out.println("password" +user.getPassword());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        else
            return "failed";
    }

}
