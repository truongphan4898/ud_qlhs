<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantruong
  Date: 29/04/2024
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit student</title>
</head>
<body>
<h1>Edit Student</h1>
<p>
    <c:if test='${sessionScope=["message"] !=null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="student">Back to student list</a>
</p>
<form method="post">
    <fieldset>
      <legend>Student Information</legend>
        <table>
            <tr>
                <td>First Name</td>
                <td>
                    <input type="text" name="firstname" id="firstname" value="${requestScope["student"].getFirstName()}">
                </td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastname" id="lastname" value="${requestScope["student"].getlastName()}"></td>
            </tr>
            <tr>
                <td>Day of birth</td>
                <td><input type="text" name="dob" id="dob" value="${requestScope["student"].getDob()}"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" id="addrress" value="${requestScope["student"].getAddress()}"></td>
            </tr>
            <tr>
                <td>Mark</td>
                <td><input type="text" name="mark" id="mark" value="${requestScope["student"].getMark()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update student"></td>
            </tr>

        </table>
    </fieldset>
</form>

</body>
</html>
