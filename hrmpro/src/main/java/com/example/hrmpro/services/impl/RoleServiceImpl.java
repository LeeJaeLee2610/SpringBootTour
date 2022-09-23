package com.example.hrmpro.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmpro.entity.Role;
import com.example.hrmpro.repositories.RoleRepository;
import com.example.hrmpro.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Role deleteRole(Role role) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Role getRole(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Role updateRole(Role role) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
