package com.example.javaeedemo.controller;

import com.example.javaeedemo.model.Subject;
import com.example.javaeedemo.service.SubjectService;
import com.example.javaeedemo.service.impl.SubjectServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subjects")
public class SubjectServlet extends HttpServlet {

    private SubjectService subjectService = new SubjectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjects = subjectService.getAllSubjects();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/subjects.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle adding new subjects
    }
}
