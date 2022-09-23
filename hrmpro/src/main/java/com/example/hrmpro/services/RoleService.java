package com.example.hrmpro.services;

import com.example.hrmpro.entity.Role;

public interface RoleService {
    Role getRole(Integer id);
    Role createRole(Role role);
    Role updateRole(Role role);
    Role deleteRole(Role role);
}
