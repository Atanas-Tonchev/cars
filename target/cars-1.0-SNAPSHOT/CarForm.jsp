<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${innerList != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${innerList == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cell-padding="5">
            <caption>
                <h2>
                    <c:if test="${innerList != null}">
                        Edit Car
                    </c:if>
                    <c:if test="${innerList == null}">
                        Add New Car
                    </c:if>
                </h2>
            </caption>
                <c:if test="${innerList != null}">
                    <input type="hidden" name="id" value="<c:out value='${innerList.car_id}' />" />
                </c:if>

                <td col-span="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>