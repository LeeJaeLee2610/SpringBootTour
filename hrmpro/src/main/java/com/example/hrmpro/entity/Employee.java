package com.example.hrmpro.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @Column(name = "employee_id")
    private int eid;
    @Column(name = "employee_name")
    private String ename;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "address")
    private String address;
    @Column(name = "gmail")
    private String gmail;
    @Column(name = "department_id")
    private String did;
    public Employee(int eid) {
        this.eid = eid;
    } 
}
