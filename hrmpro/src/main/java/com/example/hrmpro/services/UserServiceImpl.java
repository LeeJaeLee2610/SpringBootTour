package com.example.hrmpro.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

// import java.util.HashSet;
// import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.context.annotation.Lazy;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hrmpro.DTO.UserDTO;
import com.example.hrmpro.entity.User;
import com.example.hrmpro.exceptions.DuplicateException;
import com.example.hrmpro.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // @Lazy
    // private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        // return null;
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    @Override
    public User addUser(UserDTO userDTO) throws DuplicateException {
        // TODO Auto-generated method stub
        User u = userRepository.findByUsername(userDTO.getUsername());
        if(u != null){
            throw new DuplicateException("User đã tồn tại");
        }
        return userRepository.save(u);
    }

    @Override
    public void deleteUser(Integer uid) {
        // TODO Auto-generated method stub
        userRepository.deleteById(uid);
    }

    @Override
    public Optional<User> getUserByUid(Integer uid) {
        // TODO Auto-generated method stub
        return userRepository.findById(uid);
    }

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        return null;
    } 
    
    
}
