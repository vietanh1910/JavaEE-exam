package com.example.javaeedemo.dao;

import com.example.javaeedemo.model.Student;
import com.example.javaeedemo.model.StudentFullInfo;

import java.util.List;

public interface StudentDAO {
    List<StudentFullInfo> getAllStudents();
    Student getStudentById(int id);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
}
