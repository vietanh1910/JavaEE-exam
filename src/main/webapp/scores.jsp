<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Scores</title>
</head>
<body>
<h1>Student Scores</h1>

<h2>Add New Score for Student ID: ${studentId}</h2>
<form action="scores" method="post">
  <input type="hidden" name="action" value="add">
  <input type="hidden" name="studentId" value="${studentId}"> <%-- Make sure to pass the student ID back--%>
  Subject ID: <input type="number" name="subjectId"><br>
  Score 1: <input type="number" step="0.1" name="score1"><br>
  Score 2: <input type="number" step="0.1" name="score2"><br>
  <button type="submit">Add Score</button>
</form>

<h2>Scores for Student ID: ${studentId}</h2>
<table>
  <thead>
  <tr>
    <th>Student Score ID</th>
    <th>Subject ID</th>
    <th>Score 1</th>
    <th>Score 2</th>
    <th>Grade</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="score" items="${studentScores}">
    <tr>
      <td>${score.studentScoreId}</td>
      <td>${score.subjectId}</td>
      <td>${score.score1}</td>
      <td>${score.score2}</td>
      <td>
          <%-- Use JSTL to call the function  --%>
        <c:set var="grade" value="${studentScoreService.convertScoreToGrade(score.score1, score.score2)}" />
          ${grade}
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>