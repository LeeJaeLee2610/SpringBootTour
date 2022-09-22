package com.example.hrmpro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrmpro.model.EmailDetails;
import com.example.hrmpro.services.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public String sendMail(@RequestBody EmailDetails emailDetails){
        return "Hello";
    }
}
