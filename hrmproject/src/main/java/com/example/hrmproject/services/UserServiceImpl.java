package com.example.hrmproject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmproject.model.Role;
import com.example.hrmproject.model.User;
import com.example.hrmproject.repositories.RoleRepository;
import com.example.hrmproject.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void addRoleToUser(String username, String role_name) {
        // TODO Auto-generated method stub
        log.info("Adding role {} to user {}", username, role_name);
        User user = userRepository.findByUserName(username);
        Role role = roleRepository.findByRoleName(role_name);
    }

    @Override
    public User getUser(String username) {
        // TODO Auto-generated method stub
        log.info("Fetching user {}", username);
        return userRepository.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        log.info("Fetching All");
        return userRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        // TODO Auto-generated method stub
        log.info("Saving new Role {} to the database", role.getRole_id());
        return roleRepository.save(role);
    }

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        log.info("Saving new User {} to the database", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role findRoleById(Integer id) {
        // TODO Auto-generated method stub
        return roleRepository.findByRoleId(id);
    }
    
    
}
