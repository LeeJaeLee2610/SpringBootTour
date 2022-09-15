package com.example.spring_postgre.repositories;

import com.example.spring_postgre.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from students where sid = :sid", nativeQuery = true)
    Student  findStudentBySid(@Param("sid") Integer sid);
//    @Transactional
//    @Modifying
//    @Query(value = "insert into students (name, age, dob, khoa) values(:name, :age, :dob, :khoa)", nativeQuery = true)
//    void addStudent(@Param("name") String name, @Param("age") Integer age, @Param("dob") String dob, @Param("khoa") String khoa);
}
