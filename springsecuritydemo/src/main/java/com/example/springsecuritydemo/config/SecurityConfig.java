package com.example.springsecuritydemo.config;

import com.example.springsecuritydemo.services.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        // In-memory
        auth.inMemoryAuthentication().withUser("Pardeep").password(passwordEncoder().encode("test@123")).authorities("USER", "ADMIN");

        // DB Auth
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Tất cả đều có thế truy cập
//        http.authorizeHttpRequests().anyRequest().permitAll();
        http.authorizeRequests((request) -> request.antMatchers("/h2-console/**").permitAll().anyRequest().authenticated()).httpBasic();
        http.formLogin();
//        http.httpBasic();
        http.csrf().disable().headers().frameOptions().disable();   
    }
}
