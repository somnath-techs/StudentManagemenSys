package com.example.mypro.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mypro.Entity.StudentEntity;
import com.example.mypro.Repository.StudentsRepository;

@Service
public class StudentServicesImpl implements StudentSevices{

    @Autowired
    private StudentsRepository studentsRepository;

    public StudentServicesImpl(StudentsRepository studentsRepository){
        this.studentsRepository= studentsRepository;
    }

    public List<StudentEntity> getAllStudents(){
        return studentsRepository.findAll();
    }
    public void addStudent(StudentEntity studentEntity){
        studentsRepository.save(studentEntity);
    }
    public void deleteStudent(Long id){
        studentsRepository.deleteById(id);
    }
   
    public Optional<StudentEntity>FindById(Long id) {
    return studentsRepository.findById(id);
}
}
