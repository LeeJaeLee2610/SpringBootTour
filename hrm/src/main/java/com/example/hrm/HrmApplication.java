package com.example.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hrm.models.Role;
import com.example.hrm.models.User;
import com.example.hrm.repositories.RoleRepository;
import com.example.hrm.repositories.UserRepository;


@SpringBootApplication
public class HrmApplication implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(HrmApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        for(Role r: roleRepository.findAll()){
            System.out.println(r);
        }
        for(User u: userRepository.findAll()){
            System.out.println(u);
        }
    }

	
}
