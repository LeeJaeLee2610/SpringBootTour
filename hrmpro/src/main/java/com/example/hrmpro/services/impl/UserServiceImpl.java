package com.example.hrmpro.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

// import java.util.HashSet;
// import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.hrmpro.entity.Employee;
import com.example.hrmpro.entity.Role;
import com.example.hrmpro.entity.User;
import com.example.hrmpro.exceptions.DuplicateException;
import com.example.hrmpro.exceptions.TrongException;
import com.example.hrmpro.repositories.EmployeeRepository;
import com.example.hrmpro.repositories.FunctionRepository;
import com.example.hrmpro.repositories.RoleRepository;
import com.example.hrmpro.repositories.UserRepository;
import com.example.hrmpro.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private FunctionRepository functionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

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
    public User addUser(User user) throws DuplicateException {
        // TODO Auto-generated method stub
        User u = userRepository.findByUsername(user.getUsername());
        if(u != null){
            log.info(new DuplicateException("User đã tồn tại").toString());
            return null;
        }else{
            User u1 = userRepository.save(new User(user.getUsername(), user.getPassword()));
            Role role = new Role();
            role.setRole_id(u1.getUid());
            role.setRole_name("USER");
            roleRepository.save(role);
            role.getFunctions().add(functionRepository.getFunctionById(1));
            role.getFunctions().add(functionRepository.getFunctionById(2));
            role.getFunctions().add(functionRepository.getFunctionById(3));
            // employeeRepository.save(new Employee(u1.getUid()));
            return u1;
        }
    }

    @Override
    public User deleteUser(User user) {
        // TODO Auto-generated method stub
        User delete_user = new User(user.getUsername(), user.getPassword());
        User findUser = userRepository.findByUsername(user.getUsername());
        if(delete_user.equals(findUser)){
            userRepository.delete(delete_user);
            return user;
            // roleRepository.deleteById(delete_user.getUid());
        }else{
            log.info(new TrongException("Sai tài khoản mật khẩu").toString());
            return null;
        }
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
    public User updatePass(User user) throws TrongException {
        // TODO Auto-generated method stub
        User u = userRepository.findByUsername(user.getUsername());
        u.setPassword(user.getPassword());
        userRepository.save(u);
        return user;
    }    
}
