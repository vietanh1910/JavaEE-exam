package com.example.javaeedemo.dao;

import com.example.javaeedemo.model.StudentScore;

import java.util.List;

public interface StudentScoreDAO {
    List<StudentScore> getStudentScoresByStudentId(int studentId);
    boolean addStudentScore(StudentScore studentScore);
    //Other CRUD Operations you need to do with score (like delete,update,..)
}
