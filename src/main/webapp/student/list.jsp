<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantruong
  Date: 29/04/2024
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h1>Students</h1>
<p>
    <a href="/student?action=create">Create new Student</a>
</p>
<table border="1">
    <tr>
<%--        <td>ID</td>--%>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Day Of Birth</td>
        <td>Address</td>
        <td>Mark</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["student"]}' var="students">
        <tr>
            <td> <a href="?action=view&id=${students.getId()}">${students.getFirstName()}</a></td>
            <td>${students.getlastName()}</td>
            <td>${students.getDob()}</td>
            <td>${students.getAddress()}</td>
            <td>${students.getMark()}</td>
            <td> <a href="?action=edit&id=${students.getId()}">edit</a> </td>
            <td> <a href="student/action=delete&id=${students.getId}">delete</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
