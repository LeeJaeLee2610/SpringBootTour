package com.example.hrmpro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrmpro.DTO.UserDTO;
import com.example.hrmpro.entity.User;
import com.example.hrmpro.exceptions.DuplicateException;
import com.example.hrmpro.exceptions.TrongException;
import com.example.hrmpro.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired PasswordEncoder passwordEncoder;

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody User user) throws DuplicateException{
        User new_user = new User();
        new_user.setUsername(user.getUsername());
        new_user.setPassword(passwordEncoder.encode(user.getPassword()));
        User u = userService.addUser(new_user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(u.getUsername()));
    }

    @PutMapping("/updatePass")
    public ResponseEntity<UserDTO> updatePass(@RequestBody User user) throws TrongException{
        User update_user = new User();
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User u = userService.updatePass(update_user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(u.getUsername()));
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<UserDTO> deleteUser(@RequestBody User user){
        User delete_user = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()));
        User u = userService.deleteUser(delete_user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(u.getUsername()));
    }
}
