package com.example.spring_postgre.database;

import com.example.spring_postgre.model.Student;
import com.example.spring_postgre.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Database {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentBySid(Integer sid){
        return studentRepository.findStudentBySid(sid);
    }
}
