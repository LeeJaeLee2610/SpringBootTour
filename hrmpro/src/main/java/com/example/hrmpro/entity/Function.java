package com.example.hrmpro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "function")
@Data
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "function_id")
    private int fid;
    @Column(name = "function_name")
    private String fname;

    @ManyToMany(mappedBy = "functions", cascade = { CascadeType.ALL })
    private Set<Role> roles = new HashSet<Role>();

    public Function() {
    }

    public Function(int fid, String fname) {
        this.fid = fid;
        this.fname = fname;
    }

    
}
