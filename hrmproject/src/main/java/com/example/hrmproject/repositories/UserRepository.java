package com.example.hrmproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hrmproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User findByUserName(@Param("username") String username);
}
