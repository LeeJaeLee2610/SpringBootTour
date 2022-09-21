package com.example.hrmpro.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrmpro.jwt.JwtTokenProvider;
import com.example.hrmpro.model.User;
import com.example.hrmpro.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String authenticateUser(@RequestBody User user, HttpServletResponse httpServletResponse)
    {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(password);

        try {
            // Kiểm tra đăng nhập. Nếu user login thành công thì sẽ không có exception.
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return jwtTokenProvider.generateToken(userDetails);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            return "Error";
        }
    }

    @PostMapping("/signup")
    public void save(@RequestBody User user){
        System.out.println(user.getUsername());
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        userRepository.addUser(username, password);
    }

    @GetMapping("/home")
    public User home(){
        return userRepository.findByUsername("ducbui");
    }
}
