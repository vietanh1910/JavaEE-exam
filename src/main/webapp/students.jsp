<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information System</title>
</head>
<body>
<h1>Student Information System</h1>

<h2>Student List</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.studentCode}</td>
            <td>${student.fullName}</td>
            <td>${student.address}</td>
            <td><a href="scores?studentId=${student.studentId}">View Scores</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Add New Student</h2>
<form action="students" method="post">
    <input type="hidden" name="action" value="add">
    Student ID: <input type="text" name="studentCode"><br>
    Full Name: <input type="text" name="fullName"><br>
    Address: <input type="text" name="address"><br>
    <button type="submit">Add Student</button>
</form>
</body>
</html>