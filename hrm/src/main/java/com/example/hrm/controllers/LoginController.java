package com.example.hrm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrm.jwt.JwtTokenProvider;
import com.example.hrm.payload.LoginRequest;
import com.example.hrm.payload.LoginResponse;
import com.example.hrm.payload.RandomStuff;
import com.example.hrm.security.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {

        System.out.println(loginRequest);
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    @GetMapping("/random")
    public RandomStuff randomStuff(){
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }
}
