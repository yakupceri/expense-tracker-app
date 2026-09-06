package com.yakupceri.expense_tracker_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yakupceri.expense_tracker_backend.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Kullanıcıyı kullanıcı adı ile bulmak için bir yöntem tanımlıyoruz.
    Optional<User> findByUsername(String username);
}
