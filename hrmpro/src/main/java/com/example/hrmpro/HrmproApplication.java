package com.example.hrmpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hrmpro.repositories.FunctionRepository;

@SpringBootApplication
public class HrmproApplication implements CommandLineRunner{
	@Autowired
	private FunctionRepository functionRepository;

	public static void main(String[] args) {
		SpringApplication.run(HrmproApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
		System.out.println(functionRepository.getFunctionById(1).getFname());
    }

	
}
