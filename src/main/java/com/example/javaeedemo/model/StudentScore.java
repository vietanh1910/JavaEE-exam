package com.example.javaeedemo.model;

public class StudentScore {
    private int studentScoreId;
    private int studentId;
    private int subjectId;
    private double score1;
    private double score2;

    // Constructors, Getters, Setters
    public StudentScore() {}

    public StudentScore(int studentScoreId, int studentId, int subjectId, double score1, double score2) {
        this.studentScoreId = studentScoreId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score1 = score1;
        this.score2 = score2;
    }

    public int getStudentScoreId() {
        return studentScoreId;
    }

    public void setStudentScoreId(int studentScoreId) {
        this.studentScoreId = studentScoreId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }
}
