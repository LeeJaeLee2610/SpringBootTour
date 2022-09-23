package com.example.hrmpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hrmpro.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update role set role_name = :role_name where role_id = :role_id", nativeQuery = true)
    Role updateRole(@Param("role_id") int rid, @Param("role_name") String rname);
}
