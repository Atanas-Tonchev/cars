<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="styleJsp.css" />
<html lang="en">
<head>
    <title>My Cars</title>

</head>
<body>
    <div class="container">
        <div class="box">
            <table border="0" cellpadding="5">
                <center>
                <h1>WELCOME TO MY SERVER</h1>
                </center>
            </table>
        </div>
        <form action="CarServlet" method="post">
            <table border="0" cellpadding="5">
               <a href="./new" class="btn" >add new <i class="fa fa-car" aria-hidden="true"></i></a>
            </table>
        </form>
    </div>
    <section class="table_body">
        <div align="center">
            <table border="5" cellpadding="1">
               <h1>List of Cars</h1>
                    <tr>
                        <th>ID</th>
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
                                    <a href="./edit?id=<c:out value='${car.id}' />" <i class="fa fa-pencil-square" aria-hidden="true"></i></a>

                                </td>
                                <td><a href="./delete?id=<c:out value='${car.id}' />"<i class="fa fa-trash" aria-hidden="true"></i></a></td>
                            </tr>
                        </c:forEach>
            </table>
        </div>
    </section>
</body>
</html>