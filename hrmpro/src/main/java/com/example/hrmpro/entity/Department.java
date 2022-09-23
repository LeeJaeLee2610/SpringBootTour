package com.example.hrmpro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @Column(name = "department_id")
    private int did;
    @Column(name = "department_name")
    private String dname;
}
