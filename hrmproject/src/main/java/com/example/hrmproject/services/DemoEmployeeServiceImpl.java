package com.example.hrmproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.hrmproject.model.DemoEmployee;
import com.example.hrmproject.repositories.DemoEmployeeRepository;

@Service
public class DemoEmployeeServiceImpl implements DemoEmployeeService{
    @Autowired
    private DemoEmployeeRepository demoEmployeeRepository;

    @Override
    public List<DemoEmployee> listAll() {
        // TODO Auto-generated method stub
        return demoEmployeeRepository.findAll(Sort.by("name").ascending());
    }   
}
