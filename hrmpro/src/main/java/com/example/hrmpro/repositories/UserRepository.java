package com.example.hrmpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hrmpro.model.User;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    @Modifying
    @Transactional
    @Query(value = "insert into users(username, password) values(:username, :password)", nativeQuery = true)
    void addUser(@Param("username") String username, @Param("password") String password);
}
