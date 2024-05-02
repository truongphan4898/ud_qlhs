<%--
  Created by IntelliJ IDEA.
  User: phantruong
  Date: 29/04/2024
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Student</title>
</head>
<body>
<h1>Student detail</h1>
<p>
    <a href="student"> Back to student list </a>
</p>
<table>
    <tr>
        <td>First Name</td>
        <td>${requestScope["student"].getFirstName()}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${requestScope["student"].getLastName()}</td>
    </tr>
    <tr>
        <td>Day of birth</td>
        <td>${requestScope["student"].getDob()}</td>
    </tr>
    <tr>
        <td>Address</td>
        <td>${requestScope["student"].getAddress()}</td>
    </tr>
    <tr>
        <td>Mark</td>
        <td>${requestScope["student"].getMark()}</td>
</tr>
</table>
</body>
</html>
