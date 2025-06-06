package com.example.javaeedemo.dao;

import com.example.javaeedemo.model.Subject;
import java.util.List;

public interface SubjectDAO {
    List<Subject> getAllSubjects();
    Subject getSubjectById(int id);
    boolean addSubject(Subject subject);
    boolean updateSubject(Subject subject);
    boolean deleteSubject(int id);
}
