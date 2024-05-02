<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantruong
  Date: 29/04/2024
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Student</title>
</head>
<body>
<h1>Create new student</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message"> ${requestScope["message"]}</span>

    </c:if>
</p>
<p>
    <a href="student">back to student list</a>
</p>
<form method="post">
    <table>
        <tr>
            <td>First Name: </td>
            <td><input type="text" name="firstname" id="firstname"></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><input type="text" name="lastname" id="lastname"></td>
        </tr>
        <tr>
            <td>Day of birth: </td>
            <td><input type="text" name="dob" id="dob"></td>
        </tr>

        <tr>
            <td>Address: </td>
            <td><input type="text" name="address" id="address"></td>
        </tr>
        <tr>
            <td>Mark: </td>
            <td><input type="text" name="mark" id="mark"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create student"></td>
        </tr>
    </table>
    </fieldset>

</form>

</body>
</html>
