package com.example.mongodb.controller;


import com.example.mongodb.model.StudentModel;
import com.example.mongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody StudentModel studentModel) {
        StudentModel save = this.studentRepository.save(studentModel);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getStudent() {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        this.studentRepository.deleteById(id);
        return "student deleted with id: " + id;
    }

    @PutMapping("/updateStudentDetail/{id}")
    public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel studentModel,
                                                      @PathVariable("id") int id) {
        StudentModel studentDetail = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for this id :: " + id));
        studentDetail.setCity(studentModel.getCity());
        studentDetail.setCollege(studentModel.getCollege());
        studentDetail.setName(studentModel.getName());
        final StudentModel updatedStudent = studentRepository.save(studentDetail);
        return ResponseEntity.ok(updatedStudent);
    }
}
