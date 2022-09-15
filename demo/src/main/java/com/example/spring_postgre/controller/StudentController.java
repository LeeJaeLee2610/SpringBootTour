package com.example.spring_postgre.controller;

import com.example.spring_postgre.services.StudentService;
import com.example.spring_postgre.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudentBySid/{sid}")
    public Student getStuBySid(@PathVariable String sid){
        return studentService.getStudentBySid(Integer.parseInt(sid));
    }

    @PostMapping("/postStudent")
    public Student postStudent(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age, @RequestParam(value = "dob") String dob, @RequestParam(value = "khoa") String khoa){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = sdf.parse(dob);
            Student stu = new Student(name, age, date, khoa);
            studentService.addStudent(stu);
            return stu;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/putStudent/{sid}")
    public Student putStudent(@PathVariable(value = "sid") String sid, @RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age, @RequestParam(value = "dob") String dob, @RequestParam(value = "khoa") String khoa){
        Student stu = studentService.getStudentBySid(Integer.parseInt(sid));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = sdf.parse(dob);
            stu.setName(name);
            stu.setAge(age);
            stu.setDob(date);
            stu.setKhoa(khoa);
            studentService.updateStudent(stu);
            return stu;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/deleteStudent/{sid}")
    public String deleteStudentBySid(@PathVariable String sid){
        studentService.deleteStudent(Integer.parseInt(sid));
        return "Delete OK";
    }
}
