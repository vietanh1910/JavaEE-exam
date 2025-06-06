package com.example.javaeedemo.dao.impl;



import com.example.javaeedemo.dao.StudentScoreDAO;
import com.example.javaeedemo.model.StudentScore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentScoreDAOImpl implements StudentScoreDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sis";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    @Override
    public List<StudentScore> getStudentScoresByStudentId(int studentId) {
        List<StudentScore> studentScores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student_score_t WHERE student_id = ?")) {

            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StudentScore studentScore = new StudentScore();
                studentScore.setStudentScoreId(resultSet.getInt("student_score_id"));
                studentScore.setStudentId(resultSet.getInt("student_id"));
                studentScore.setSubjectId(resultSet.getInt("subject_id"));
                studentScore.setScore1(resultSet.getDouble("score1"));
                studentScore.setScore2(resultSet.getDouble("score2"));
                studentScores.add(studentScore);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentScores;
    }

    @Override
    public boolean addStudentScore(StudentScore studentScore) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student_score_t (student_id, subject_id, score1, score2) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setInt(1, studentScore.getStudentId());
            preparedStatement.setInt(2, studentScore.getSubjectId());
            preparedStatement.setDouble(3, studentScore.getScore1());
            preparedStatement.setDouble(4, studentScore.getScore2());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
