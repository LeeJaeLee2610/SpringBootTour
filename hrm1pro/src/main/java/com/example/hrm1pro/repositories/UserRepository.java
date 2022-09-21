package com.example.hrm1pro.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hrm1pro.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // User findByUsername(String username);
    // @Query(value = "insert into users(username, password) values(:username, :password)", nativeQuery = true)
    // UserRepository saveUser(@Param("username") String username, @Param("password") String password);
    User findByUsername(String username);
}
