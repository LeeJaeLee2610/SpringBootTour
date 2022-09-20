package com.example.hrmproject.services;

import java.util.List;

import com.example.hrmproject.model.Role;
import com.example.hrmproject.model.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    Role findRoleById(Integer id);
    void addRoleToUser(String username, String role_name);
    User getUser(String username);
    List<User> getUsers();
    
}
