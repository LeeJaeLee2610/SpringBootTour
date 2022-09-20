package com.example.hrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrm.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    User findByUid(Integer uid);
}
