package com.example.springsecuritydemo.repositories;

import com.example.springsecuritydemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
