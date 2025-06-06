package com.example.javaeedemo.service;

import com.example.javaeedemo.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject getSubjectById(int id);
    boolean addSubject(Subject subject);
    boolean updateSubject(Subject subject);
    boolean deleteSubject(int id);
}
