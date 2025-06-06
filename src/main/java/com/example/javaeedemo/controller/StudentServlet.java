package com.example.javaeedemo.controller;

import com.example.javaeedemo.model.Student;
import com.example.javaeedemo.model.StudentFullInfo;
import com.example.javaeedemo.service.StudentService;
import com.example.javaeedemo.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StudentFullInfo> students = studentService.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle adding new students (from +Student button)
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String studentCode = request.getParameter("studentCode");
            String fullName = request.getParameter("fullName");
            String address = request.getParameter("address");

            Student newStudent = new Student();
            newStudent.setStudentCode(studentCode);
            newStudent.setFullName(fullName);
            newStudent.setAddress(address);

            boolean added = studentService.addStudent(newStudent);
            if (added) {
                response.sendRedirect("students"); // Refresh the page
            } else {
                request.setAttribute("errorMessage", "Failed to add student.");
                request.getRequestDispatcher("/students.jsp").forward(request, response);
            }
        }
    }
}
