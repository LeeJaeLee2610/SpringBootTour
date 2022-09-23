package com.example.hrmpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hrmpro.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    // @Modifying
    // @Transactional
    // @Query(value = "insert into employee(employee_id) values(:employee_id)", nativeQuery = true)
    // Employee addEmployee(@Param("employee_id") Integer eid);
}
