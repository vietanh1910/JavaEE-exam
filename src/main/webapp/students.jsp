<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f6f6f6;
            margin: 0;
            padding: 20px;
        }

        h1 {
            background-color: #4e6b4e;
            color: white;
            padding: 15px;
            text-align: center;
            border-radius: 5px;
        }

        h2 {
            color: #4e6b4e;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            margin-top: 20px;
            box-shadow: 0 0 10px #ccc;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4e6b4e;
            color: white;
        }

        tr:hover {
            background-color: #f2f2f2;
        }

        form {
            margin-top: 30px;
            background-color: white;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 0 8px #ccc;
            width: 300px;
        }

        input[type="text"], button {
            padding: 8px;
            margin-top: 5px;
            width: 100%;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4e6b4e;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #3b523b;
        }
    </style>
</head>
<body>
<h1>Student Information System</h1>
<h2>Student Infomation</h2>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Subject Name</th>
        <th>Score 1</th>
        <th>Score 2</th>
        <th>Credit</th>
        <th>Grade</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${students}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${s.studentCode}</td>
            <td>${s.fullName}</td>
            <td>${s.subjectName}</td>
            <td>${s.score1}</td>
            <td>${s.score2}</td>
            <td>${s.credit}</td>
            <td>${s.grade}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<h2>Add New Student</h2>
<form action="students" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="studentCode" placeholder="Student ID">
    <input type="text" name="fullName" placeholder="Full Name">
    <input type="text" name="address" placeholder="Address">
    <button type="submit">Add Student</button>
</form>
</body>
</html>
