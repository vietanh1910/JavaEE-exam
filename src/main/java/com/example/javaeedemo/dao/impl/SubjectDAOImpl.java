package com.example.javaeedemo.dao.impl;


import com.example.javaeedemo.dao.SubjectDAO;
import com.example.javaeedemo.model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sis";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    private Connection getConnection() throws SQLException {
        // Nếu cần, thêm: Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT subjectId, subjectCode, subjectName, credit FROM subject";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectId(rs.getInt("subjectId"));
                subject.setSubjectCode(rs.getString("subjectCode"));
                subject.setSubjectName(rs.getString("subjectName"));
                subject.setCredit(rs.getInt("credit"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    @Override
    public Subject getSubjectById(int id) {
        Subject subject = null;
        String sql = "SELECT subjectId, subjectCode, subjectName, credit FROM subject WHERE subjectId = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    subject = new Subject();
                    subject.setSubjectId(rs.getInt("subjectId"));
                    subject.setSubjectCode(rs.getString("subjectCode"));
                    subject.setSubjectName(rs.getString("subjectName"));
                    subject.setCredit(rs.getInt("credit"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    @Override
    public boolean addSubject(Subject subject) {
        String sql = "INSERT INTO subject (subjectCode, subjectName, credit) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, subject.getSubjectCode());
            stmt.setString(2, subject.getSubjectName());
            stmt.setInt(3, subject.getCredit());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateSubject(Subject subject) {
        String sql = "UPDATE subject SET subjectCode = ?, subjectName = ?, credit = ? WHERE subjectId = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, subject.getSubjectCode());
            stmt.setString(2, subject.getSubjectName());
            stmt.setInt(3, subject.getCredit());
            stmt.setInt(4, subject.getSubjectId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteSubject(int id) {
        String sql = "DELETE FROM subject WHERE subjectId = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
