package com.example.javaeedemo.dao.impl;

import com.example.javaeedemo.dao.StudentDAO;
import com.example.javaeedemo.model.Student;
import com.example.javaeedemo.model.StudentFullInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sis";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    @Override
    public List<StudentFullInfo> getAllStudents() {
        String sql = " SELECT s.student_id, s.student_code, s.full_name, s.address, subj.subject_name, subj.credit, sc.score1, sc.score2 " +
                "FROM student_t s " +
                "JOIN student_score_t sc ON s.student_id = sc.student_id " +
                "JOIN subject_t subj ON sc.subject_id = subj.subject_id ";
        List<StudentFullInfo> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                StudentFullInfo info = new StudentFullInfo();
                info.setStudentId(resultSet.getInt("student_id"));
                info.setStudentCode(resultSet.getString("student_code"));
                info.setFullName(resultSet.getString("full_name"));
                info.setAddress(resultSet.getString("address"));
                info.setSubjectName(resultSet.getString("subject_name"));
                info.setCredit(resultSet.getInt("credit"));
                info.setScore1(resultSet.getDouble("score1"));
                info.setScore2(resultSet.getDouble("score2"));
                students.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student_t WHERE student_id = ?")) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setStudentCode(resultSet.getString("student_code"));
                student.setFullName(resultSet.getString("full_name"));
                student.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean addStudent(Student student) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student_t (student_code, full_name, address) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, student.getStudentCode());
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setString(3, student.getAddress());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student_t SET student_code = ?, full_name = ?, address = ? WHERE student_id = ?")) {

            preparedStatement.setString(1, student.getStudentCode());
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setInt(4, student.getStudentId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student_t WHERE student_id = ?")) {

            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
