package com.example.javaeedemo.model;
public class Student {
    private int studentId;
    private String studentCode;
    private String fullName;
    private String address;

    // Constructors, Getters, Setters
    public Student() {}

    public Student(int studentId, String studentCode, String fullName, String address) {
        this.studentId = studentId;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.address = address;
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
}
