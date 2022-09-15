package com.example.spring_postgre.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Integer sid;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "khoa")
    private String khoa;

    public Student() {
    }

    public Student(String name, Integer age, Date dob, String khoa) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.khoa = khoa;
    }

//    public Student(Integer sid, String name, Integer age, String dob, String khoa) {
//        this.sid = sid;
//        this.name = name;
//        this.age = age;
//        this.dob = dob;
//        this.khoa = khoa;
//    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
