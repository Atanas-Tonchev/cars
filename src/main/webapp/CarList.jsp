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
            <a href="./CarServlet/new">Add New Car</a>
            &nbsp;&nbsp;&nbsp;
            <a href="./CarServlet/list">List All Cars</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cell-padding="5">
            <caption><h2>List of Cars</h2></caption>
            <tr>
                <th> ID </th>
                <th> Dimensions Height </th>
                <th> Dimensions Length </th>
                <th> Dimensions Width </th>
                <th> Drive Line </th>
                <th> Engine Type </th>
                <th> Hybrid </th>
                <th> Transmission </th>
                <th> Number of forward gears </th>
                <th> Horsepower </th>
                <th> Torque </th>
                <th> Fuel Type </th>
                <th> City mpg </th>
                <th> Highway mpg </th>
                <th> Classification </th>
                <th> Identification </th>
                <th> Make </th>
                <th> Model & Year </th>
                <th> Year </th>
            </tr>

            <c:forEach var="car" items="${list}">
                   <tr>
                      <td><c:out value = '${car.id}' /></td>
                      <td><c:out value = "${car.dimensions.height}" /></td>
                      <td><c:out value = "${car.dimensions.length}" /></td>
                      <td><c:out value = "${car.dimensions.width}" /></td>
                      <td><c:out value = "${car.engineInformation.driveLine}" /></td>
                      <td><c:out value = "${car.engineInformation.engineType}" /></td>
                      <td><c:out value = "${car.engineInformation.hybrid}" /></td>
                      <td><c:out value = "${car.engineInformation.transmission}" /></td>
                      <td><c:out value = "${car.engineInformation.numberOfForwardGears}" /></td>
                      <td><c:out value = "${car.engineInformation.engineStatistics.horsepower}" /></td>
                      <td><c:out value = "${car.engineInformation.engineStatistics.torque}" /></td>
                      <td><c:out value = "${car.fuelInformation.fuelType}" /></td>
                      <td><c:out value = "${car.fuelInformation.cityMpg}" /></td>
                      <td><c:out value = "${car.fuelInformation.highwayMpg}" /></td>
                      <td><c:out value = "${car.identification.classification}" /></td>
                      <td><c:out value = "${car.identification.ID}" /></td>
                      <td><c:out value = "${car.identification.make}" /></td>
                      <td><c:out value = "${car.identification.modelYear}" /></td>
                      <td><c:out value = "${car.identification.year}" /></td>
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