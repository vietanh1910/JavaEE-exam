package com.example.javaeedemo.service.impl;

import com.example.javaeedemo.dao.SubjectDAO;
import com.example.javaeedemo.dao.impl.SubjectDAOImpl;
import com.example.javaeedemo.model.Subject;
import com.example.javaeedemo.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private SubjectDAO subjectDAO = new SubjectDAOImpl();

    @Override
    public List<Subject> getAllSubjects() {
        return subjectDAO.getAllSubjects();
    }

    @Override
    public Subject getSubjectById(int id) {
        return subjectDAO.getSubjectById(id);
    }

    @Override
    public boolean addSubject(Subject subject) {
        return subjectDAO.addSubject(subject);
    }

    @Override
    public boolean updateSubject(Subject subject) {
        return subjectDAO.updateSubject(subject);
    }

    @Override
    public boolean deleteSubject(int id) {
        return subjectDAO.deleteSubject(id);
    }
}
