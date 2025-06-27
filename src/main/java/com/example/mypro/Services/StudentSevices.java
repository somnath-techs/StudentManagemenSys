package com.example.mypro.Services;

import java.util.List;
import java.util.Optional;

import com.example.mypro.Entity.StudentEntity;

public interface StudentSevices {
    List<StudentEntity> getAllStudents();
    void addStudent(StudentEntity studentEntity);
    void deleteStudent(Long id);
    Optional<StudentEntity> FindById(Long id);
}
