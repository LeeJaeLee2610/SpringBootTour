package com.example.hrmproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmproject.model.DemoEmployee;

public interface DemoEmployeeRepository extends JpaRepository<DemoEmployee, Integer>{
    
}
