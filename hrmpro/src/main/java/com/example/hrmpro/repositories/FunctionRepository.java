package com.example.hrmpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hrmpro.entity.Function;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Integer> {  
    @Query(value = "select * from function where function_id = :function_id",  nativeQuery = true)
    Function getFunctionById(@Param("function_id") Integer id);
}
