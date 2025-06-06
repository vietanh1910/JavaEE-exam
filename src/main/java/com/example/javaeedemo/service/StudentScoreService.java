package com.example.javaeedemo.service;

import com.example.javaeedemo.model.StudentScore;

import java.util.List;

public interface StudentScoreService {
    List<StudentScore> getStudentScoresByStudentId(int studentId);
    boolean addStudentScore(StudentScore studentScore);
    String convertScoreToGrade(double score1, double score2);
}
