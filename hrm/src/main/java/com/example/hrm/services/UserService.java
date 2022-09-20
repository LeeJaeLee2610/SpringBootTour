package com.example.hrm.services;

import javax.transaction.Transactional;

import com.example.hrm.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hrm.models.User;
import com.example.hrm.repositories.UserRepository;
import com.example.hrm.security.CustomUserDetails;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User u = userRepository.findByUsername(username);
        if(u == null)
        {
            throw new UsernameNotFoundException("User not found!");
        }
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
//        Role role = u.getRole();
        grantedAuthoritySet.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), grantedAuthoritySet);

    }
}
