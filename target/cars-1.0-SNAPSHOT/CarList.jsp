<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Cars Store Application</title>
</head>
<body>
    <center>
        <h1>Cars Management</h1>
        <h2>
            <a href="/new">Add New Car</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Cars</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cell-padding="5">
            <caption><h2>List of Cars</h2></caption>
            <tr>
                <th>ID</th>

            </tr>

            <c:forEach var="car" items="${listCar}">
                           <tr>
                               <td><c:out value = "${car}" /></td>
                               <td>
                                   <a href="/edit?id=<c:out value='${car}' />">Edit</a>
                                   &nbsp;&nbsp;&nbsp;&nbsp;
                                   <a href="/delete?id=<c:out value='${car}' />">Delete</a>
                               </td>
                           </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>