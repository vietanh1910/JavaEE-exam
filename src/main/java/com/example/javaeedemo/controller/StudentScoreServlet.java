package com.example.javaeedemo.controller;

import com.example.javaeedemo.model.StudentScore;
import com.example.javaeedemo.service.StudentScoreService;
import com.example.javaeedemo.service.impl.StudentScoreServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scores")
public class StudentScoreServlet extends HttpServlet {

    private StudentScoreService studentScoreService = new StudentScoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display scores for a student
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        List<StudentScore> studentScores = studentScoreService.getStudentScoresByStudentId(studentId);
        request.setAttribute("studentScores", studentScores);
        request.setAttribute("studentId", studentId);  // Pass studentId to JSP
        request.getRequestDispatcher("/scores.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle inserting new score
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            int subjectId = Integer.parseInt(request.getParameter("subjectId"));
            double score1 = Double.parseDouble(request.getParameter("score1"));
            double score2 = Double.parseDouble(request.getParameter("score2"));

            StudentScore newScore = new StudentScore();
            newScore.setStudentId(studentId);
            newScore.setSubjectId(subjectId);
            newScore.setScore1(score1);
            newScore.setScore2(score2);

            boolean added = studentScoreService.addStudentScore(newScore);
            if (added) {
                response.sendRedirect("scores?studentId=" + studentId); // Redirect to display the updated scores for the student
            } else {
                request.setAttribute("errorMessage", "Failed to add score.");
                request.getRequestDispatcher("/scores.jsp").forward(request, response);
            }
        }
    }
}
