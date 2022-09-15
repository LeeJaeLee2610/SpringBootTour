package com.example.spring_postgre.services;

import com.example.spring_postgre.model.Student;
import com.example.spring_postgre.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentBySid(Integer sid){
        return studentRepository.findStudentBySid(sid);
    }

    public void addStudent(Student stu){
//        studentRepository.addStudent(name, age, dob, khoa);
        studentRepository.save(stu);
    }

    public void updateStudent(Student stu){
        studentRepository.save(stu);
    }

    public void deleteStudent(Integer sid){
        studentRepository.deleteById(sid);
    }
}
