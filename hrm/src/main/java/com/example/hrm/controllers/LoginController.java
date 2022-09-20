package com.example.hrm.controllers;

import com.example.hrm.jwt.JwtAuthenticationFilter;
import com.example.hrm.jwt.JwtTokenProvider;
import com.example.hrm.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public String authenticateUser(@RequestBody User user)
    {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(user);
        try {
            // Kiểm tra đăng nhập. Nếu user login thành công thì sẽ không có exception.
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return jwtTokenProvider.generateToken(userDetails);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            return e.getMessage();
        }
    }

}
