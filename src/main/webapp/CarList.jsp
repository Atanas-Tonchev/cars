<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="addBtn.css" />

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
<body background="wallpaperflare.com_wallpaper.jpg" style="background-size: auto;">
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
    <div class="container">
        <div class="box">
            <center style="color: #B22222;">
                <h1>WELCOME TO MY SERVER</h1>
            </center>
            </table>
        </div>
        <form action="CarServlet" method="get" align="right">
               <a href="CarForm.jsp" class="btn" >add new <i class="fa fa-car" aria-hidden="true"></i></a>
        </form>
    </div>
    <section class="table_body">

        <div align="left">
            <h2>Select by:</h2>
            <form action = "">
                <th>  Year from:
                    <select style="width:115px;height: 25px; " >
                        <option></option>

                            <option> 2009 </option>

                    </select>
                </th>
                <th> to:
                    <select style="width:115px;height: 25px; " >
                        <option></option>
                        <c:forEach var="select" items="${list}">
                            <option> 2040 </option>
                        </c:forEach>
                    </select>
                </th>
                <input class="btn" type="submit" value = "search"
                style=" width:100px; font-size: 16px; padding: 4px; background: #00FA9A;" />
            </form>
            <form action = "">
               <th>  Model:
                  <select style="width:115px;height: 25px; " >
                    <option></option>
                     <c:forEach var="select" items="${list}">
                        <option> <c:out value = "${select.identification.make}" /> </option>
                     </c:forEach>
                  </select>
               </th>
                  <input class="btn" type="submit" value = "search"
                  style=" width:100px; font-size: 16px; padding: 4px; background: #00FA9A;" />
            </form>
        </div>
        <div align="center">
            <table style="background-position: center;background-size:cover;" background="wallpaperflare.com_wallpaper.jpg" border="1" cell-padding="2" >
               <h1>List of Cars</h1>
                    <tr
                    style=" background: none; color: #000000; text-align: center; ">
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
                        <th> Edit </th>
                        <th> Delete </th>
                    </tr>
                        <c:forEach var="car" items="${list}">
                            <tr style=" background: none; color: #000000;">
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
                                    <a href="CarUpdate?carId=<c:out value='${car.id}' />">
                                    <center><i class="fa fa-pencil-square" aria-hidden="true"></i></center>
                                    </a>
                                </td>
                                <td>
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