package com.example.javaeedemo.service.impl;


import com.example.javaeedemo.dao.StudentScoreDAO;
import com.example.javaeedemo.dao.impl.StudentScoreDAOImpl;
import com.example.javaeedemo.model.StudentScore;
import com.example.javaeedemo.service.StudentScoreService;

import java.util.List;

public class StudentScoreServiceImpl implements StudentScoreService {
    private StudentScoreDAO studentScoreDAO = new StudentScoreDAOImpl();

    @Override
    public List<StudentScore> getStudentScoresByStudentId(int studentId) {
        return studentScoreDAO.getStudentScoresByStudentId(studentId);
    }

    @Override
    public boolean addStudentScore(StudentScore studentScore) {
        return studentScoreDAO.addStudentScore(studentScore);
    }

    @Override
    public String convertScoreToGrade(double score1, double score2) {
        double finalScore = 0.3 * score1 + 0.7 * score2;
        if (finalScore >= 8.0 && finalScore <= 10.0) {
            return "A";
        } else if (finalScore >= 6.0 && finalScore <= 7.9) {
            return "B";
        } else if (finalScore >= 4.0 && finalScore <= 5.9) {
            return "D";
        } else {
            return "F";
        }
    }
}