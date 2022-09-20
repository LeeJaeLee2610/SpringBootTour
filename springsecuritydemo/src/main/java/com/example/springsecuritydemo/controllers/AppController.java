package com.example.springsecuritydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/app")
public class AppController {
    @GetMapping("/")
    public String testApp(){
        return "Hello Baby";
    }
}
