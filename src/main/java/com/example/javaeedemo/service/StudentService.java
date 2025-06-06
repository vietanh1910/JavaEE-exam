package com.example.javaeedemo.service;

import com.example.javaeedemo.model.Student;
import com.example.javaeedemo.model.StudentFullInfo;

import java.util.List;

public interface StudentService {
    List<StudentFullInfo> getAllStudents();
    Student getStudentById(int id);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
}
