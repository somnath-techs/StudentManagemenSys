package com.example.mypro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mypro.Entity.StudentEntity;

@Repository
public interface StudentsRepository extends JpaRepository<StudentEntity,Long>{
    
}
