package com.example.hrmproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hrmproject.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select * from role where role_name = :role_name", nativeQuery = true)
    Role findByRoleName(@Param("role_name") String role_name);
    @Query(value = "select * from role where role_id = :role_id", nativeQuery = true)
    Role findByRoleId(@Param("role_id") Integer role_id);
}
