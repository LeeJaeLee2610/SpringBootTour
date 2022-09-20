package com.example.hrmproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrmproject.model.Role;
import com.example.hrmproject.model.User;
import com.example.hrmproject.services.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping(value="/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        //TODO: process POST request
        
        User u = userService.saveUser(user);
        Role r = new Role();
        r.setRole_id(u.getId());
        userService.saveRole(r);
        return ResponseEntity.created(null).body(userService.saveUser(user));
    }
    
    @PutMapping(value="/role/update/{id}")
    public ResponseEntity<Role> UpdateRole(@PathVariable String id, @RequestBody Role role){
        Role r1 = userService.findRoleById(Integer.parseInt(id));
        r1.setRole_name(role.getRole_name());
        userService.saveRole(r1);
        return ResponseEntity.ok().body(r1);
    }
}
