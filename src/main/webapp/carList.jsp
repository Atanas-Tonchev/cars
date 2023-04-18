<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
crossorigin="anonymous" referrerpolicy="no-referrer" />

<html lang="en">
<head>
    <title>My Cars</title>
    <style>
        tr:hover td{
        background-color: #696969;
        color: white;
        }
    </style>
</head>
<body background="pics/wallpaperflare.com_wallpaper.jpg" style="background-size: auto;">
<%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("Username")) userName = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("login.html");
%>
<form action="LogOutServlet" method="post" align="left">
<link rel="stylesheet" href="editBtn.css" />
          <input type="submit" class="btn1" value="Logout" >
</form>
    <div class="container">
        <div class="box">
            <center style="color: #B22222;">
                <h1>WELCOME TO MY SERVER</h1>
            </center>
        </div>
        <form action="CarServlet" method="get" align="right">
               <a href="carForm.jsp" class="btn" >add new <i class="fa fa-car" aria-hidden="true"></i></a>
        </form>
    </div>
    <section class="table_body">

        <div align="left">
            <link rel="stylesheet" href="searchBtn.css" />
            <a href="searchPage.jsp" class="btnSearch" >search</a>
        </div>
        <div align="center">
            <table style="background-position: center;background-size:cover;"  border="1" cell-padding="2" >
               <h1>List of Cars</h1>
                    <tr
                    style=" background: #00fa9ac2; color: #000000; text-align: center; ">
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
                        <th> View </th>
                        <th> Edit </th>
                        <th> Delete </th>
                    </tr>
                        <c:forEach var="car" items="${list}">
                            <tr style=" background: #fffff091; color: #000000;">
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
                                <td style=" background: #55b5ffb4; color: #000000; text-align: center; ">
                                    <a href="CarView?carId=<c:out value='${car.id}' />">
                                        <center><i class="fa-regular fa-eye"></i></center>
                                    </a>
                                </td>
                                <td style=" background: #d9f346b4; color: #000000; text-align: center; ">
                                    <a href="CarUpdate?carId=<c:out value='${car.id}' />">
                                    <center><i class="fa fa-pencil-square" aria-hidden="true"></i></center>
                                    </a>
                                </td>
                                <td style=" background: #f5565eb5; color: #000000; text-align: center; ">
                                    <a href="CarDelete?carId=<c:out value='${car.id}' />" >
                                    <center><i class="fa fa-trash" aria-hidden="true"></i></center>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
            </table>
        </div>
    </section>
</body>
</html>