package com.example.hrmproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

import com.example.hrmproject.consts.RolesConst;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("emcuong")
            .password("cuongne")
            .roles(RolesConst.USER)
            .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("duythinh")
            .password("thinhne")
            .roles(RolesConst.ADMIN)
            .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        return http.csrf(csrf -> csrf.disable())
            .authorizeRequests(auth -> {
                auth.antMatchers("/").permitAll();
                auth.antMatchers("/user").hasRole(RolesConst.USER);
                auth.antMatchers("/admin").hasRole(RolesConst.ADMIN);
            })
            .httpBasic(Customizer.withDefaults())
            .build();
    }
    
}
