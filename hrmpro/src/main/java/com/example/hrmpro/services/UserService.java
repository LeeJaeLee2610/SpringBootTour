package com.example.hrmpro.services;

import java.util.List;
import java.util.Optional;

import com.example.hrmpro.entity.User;
import com.example.hrmpro.exceptions.DuplicateException;
import com.example.hrmpro.exceptions.TrongException;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUserByUid(Integer uid);
    User addUser(User user) throws DuplicateException;
    User updatePass(User user) throws TrongException;
    User deleteUser(User user);
}
