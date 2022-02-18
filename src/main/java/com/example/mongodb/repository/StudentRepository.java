package com.example.mongodb.repository;

import com.example.mongodb.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentModel, Integer> {
}
