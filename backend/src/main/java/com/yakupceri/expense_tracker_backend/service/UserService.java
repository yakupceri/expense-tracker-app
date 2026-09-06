package com.yakupceri.expense_tracker_backend.service;

import org.springframework.stereotype.Service;

import com.yakupceri.expense_tracker_backend.domain.User;
import com.yakupceri.expense_tracker_backend.repository.UserRepository;

@Service 
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String username, String password) {
      //
      if(userRepository.findByUsername(username).isPresent()) {
        throw new RuntimeException("Kullanıcı adı zaten mevcut!");
      }
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(password);
    return userRepository.save(newUser);
    }
}
