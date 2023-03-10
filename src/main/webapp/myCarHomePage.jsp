<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
    <center>
        <h1>Books Management</h1>
        <h2>
            <a href="/new">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Books</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Make</th>
                <th>Year</th>

            </tr>
            <c:forEach var="car" items="${listCar1}">
                <tr>
                    <td><c:out value="${car.id}" /></td>
                    <td><c:out value="${car.identification.make}" /></td>
                    <td><c:out value="${car.identification.year}" /></td>

                    <td>
                        <a href="/edit?id=<c:out value='${car.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${car.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
 </html>