<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Subject List</title>
</head>
<body>
<h1>Subject List</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Subject Code</th>
        <th>Subject Name</th>
        <th>Credit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>${subject.subjectId}</td>
            <td>${subject.subjectCode}</td>
            <td>${subject.subjectName}</td>
            <td>${subject.credit}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>