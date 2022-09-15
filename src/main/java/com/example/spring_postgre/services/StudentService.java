package com.example.spring_postgre.service;

import com.example.spring_postgre.model.Student;
import com.example.spring_postgre.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentBySid(Integer sid){
        return studentRepository.findStudentBySid(sid);
    }
}
