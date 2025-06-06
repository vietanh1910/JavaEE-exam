package com.example.javaeedemo.service.impl;

import com.example.javaeedemo.dao.StudentDAO;
import com.example.javaeedemo.dao.impl.StudentDAOImpl;
import com.example.javaeedemo.model.Student;
import com.example.javaeedemo.model.StudentFullInfo;
import com.example.javaeedemo.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<StudentFullInfo> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDAO.deleteStudent(id);
    }
}