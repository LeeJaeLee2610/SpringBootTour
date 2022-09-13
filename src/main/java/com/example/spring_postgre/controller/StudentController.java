package com.example.spring_postgre.controller;

import com.example.spring_postgre.database.Database;
import com.example.spring_postgre.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private Database database;

    @GetMapping("/{sid}")
    public Student getStuBySid(@PathVariable String sid){
        return database.getStudentBySid(Integer.parseInt(sid));
    }
}
