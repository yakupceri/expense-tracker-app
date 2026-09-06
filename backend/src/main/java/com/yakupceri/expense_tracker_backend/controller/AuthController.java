package com.yakupceri.expense_tracker_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yakupceri.expense_tracker_backend.service.UserService;



@RestController 
@RequestMapping ("/api/auth")
@CrossOrigin(origins = "*")

public class AuthController {

    private final UserService userService;
    
    //Servisi içeri alma
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @Postmapping("/register")
   

    
}
