package com.example.javaeedemo.dao;

import com.example.javaeedemo.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
}
