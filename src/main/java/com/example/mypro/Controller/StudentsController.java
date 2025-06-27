package com.example.mypro.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mypro.Entity.StudentEntity;
import com.example.mypro.Services.StudentSevices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
public class StudentsController {

    @Autowired
    StudentSevices studentSevices;

    @PostMapping("/add")
    public ResponseEntity AddData(@RequestBody StudentEntity studentEntity) {
        try {
            studentSevices.addStudent(studentEntity);
            return ResponseEntity.ok("Student Added");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
        
    }
    @GetMapping("/getall")
    public ResponseEntity getStudents() {
        try {
            return new ResponseEntity<>(studentSevices.getAllStudents(),HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(500)); 
        }
        
    }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            studentSevices.deleteStudent(id);
            return ResponseEntity.ok("Student deleted with id: " + id);
        } catch (Exception e) {
            return new ResponseEntity<>("Delete Failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentEntity updatedStudent) {
        try {
            Optional<StudentEntity> existing = studentSevices.FindById(id);
            if (existing.isPresent()) {
                StudentEntity student = existing.get();
                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                student.setPassword(updatedStudent.getPassword());
                student.setPhone(updatedStudent.getPhone());
                studentSevices.addStudent(student); // reuse save method
                return ResponseEntity.ok("Student updated successfully");
            } else {
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Update Failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
