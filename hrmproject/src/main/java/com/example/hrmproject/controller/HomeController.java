package com.example.hrmproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "Hello World";
    }

    @GetMapping("/user")
    public String user(){
        return "Hello User";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello Admin";
    }
}
