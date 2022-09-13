package com.example.spring_postgre;

import com.example.spring_postgre.model.Student;
import com.example.spring_postgre.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringPostgreApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    private static final Logger logger = LoggerFactory.getLogger(SpringPostgreApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringPostgreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List <Student> stu = studentRepository.findAll();
        for(Student i: stu){
            logger.info(i.getSid() + " " + i.getName());
        }
    }
}
