package com.example.hrmproject;
import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hrmproject.services.FilesStorageService;

@SpringBootApplication
public class HrmprojectApplication implements CommandLineRunner{
	@Resource
	FilesStorageService filesStorageService;

	public static void main(String[] args) {
		SpringApplication.run(HrmprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		filesStorageService.deleteAll();
		filesStorageService.init();
	}

	
}
