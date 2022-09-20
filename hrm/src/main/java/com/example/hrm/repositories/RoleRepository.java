package com.example.hrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hrm.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select * from role where role_id = :role_id", nativeQuery = true)
    Role findByRoleId(@Param("role_id") Integer role_id);
}
