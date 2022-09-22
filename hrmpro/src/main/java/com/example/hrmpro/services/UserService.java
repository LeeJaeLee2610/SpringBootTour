package com.example.hrmpro.services;

import java.util.List;
import java.util.Optional;

import com.example.hrmpro.DTO.UserDTO;
import com.example.hrmpro.entity.User;
import com.example.hrmpro.exceptions.DuplicateException;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUserByUid(Integer uid);
    User addUser(UserDTO userDTO) throws DuplicateException;
    User updateUser(UserDTO userDTO);
    void deleteUser(Integer uid);
}
