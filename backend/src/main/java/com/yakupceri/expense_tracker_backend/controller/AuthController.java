package com.yakupceri.expense_tracker_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yakupceri.expense_tracker_backend.domain.User;
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

// 1. Kayıt Olma Endpoint'i (POST /api/auth/register)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User requestUser) {
        try {
            User registeredUser = userService.register(requestUser.getUsername(), requestUser.getPassword());
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    
    }
        // 2. Giriş Yapma Endpoint'i (POST /api/auth/login)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User requestUser) {
        try {
            User loggedInUser = userService.login(requestUser.getUsername(), requestUser.getPassword());
            return ResponseEntity.ok(loggedInUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
