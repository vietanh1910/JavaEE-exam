package com.example.javaeedemo.model;

public class StudentFullInfo {
    private int studentId;
    private String studentCode;
    private String fullName;

    public StudentFullInfo(int studentId, String studentCode, String fullName, String address, String subjectName, int credit, double score1, double score2) {
        this.studentId = studentId;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.address = address;
        this.subjectName = subjectName;
        this.credit = credit;
        this.score1 = score1;
        this.score2 = score2;
    }

    public StudentFullInfo() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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

    private String address;

    private String subjectName;
    private int credit;
    private double score1;
    private double score2;

    // Optional: tự tính grade (A/B/C...) từ điểm
    public String getGrade() {
        double avg = (score1 + score2) / 2;
        if (avg >= 8.0) return "A";
        else if (avg >= 6.5) return "B";
        else if (avg >= 5.0) return "C";
        else return "F";
    }

    // Getters/Setters
}

