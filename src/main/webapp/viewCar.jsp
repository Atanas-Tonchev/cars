<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<body background="pics/CarView.png" style="background-position: center;background-size:cover;">
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
    <form action="CarServlet" align="left">
        <input type="submit" class="btn" value="to All"  >
     </form> 
    <div class="container">
        <div class="box">
            <center style="color: #B22222;">
                <h1>View Car</h1>
            </center>
        </div>
    </div>
    <table align="right"> 
            
            </caption>
            <c:if test="${car != null}">
                <input type="hidden" name="id" value="<c:out value='${car.id}' />" />
            </c:if>
             <tr>
                <th>Dimensions Height: </th>
                   <td>                      
                        <c:out value='${car.dimensions.height}'></c:out>   
                   </td>
             </tr>
             <tr>
                <th>Dimensions Length: </th>
                   <td>
                    <c:out value='${car.dimensions.length}'></c:out>
                   </td>
             </tr>
             <tr>
                <th>Dimensions Width: </th>
                    <td>
                        <c:out value='${car.dimensions.width}'></c:out>
                    </td>
             </tr>
             <tr>
                <th>Drive Line: </th>
                    <td>
                        <c:out value='${car.engineInformation.driveLine}'></c:out>
                    </td>
             </tr>
             <tr>
                <th>Engine Type: </th>
                    <td>
                        <c:out value='${car.engineInformation.engineType}'></c:out>
                    </td>
             </tr>
             <tr>
                 <th>Hybrid: </th>
                    <td>
                        <c:out value='${car.engineInformation.hybrid}'></c:out>
                    </td>
             </tr>
             <tr>
                 <th>Transmission: </th>
                    <td>
                        <c:out value='${car.engineInformation.transmission}'></c:out>
                    </td>
             </tr>
             <tr>
                 <th>Number of forward gears: </th>
                    <td>
                        <c:out value='${car.engineInformation.numberOfForwardGears}'></c:out>
                    </td>
             </tr>
             <tr>
                 <th>Horsepower: </th>
                    <td>
                        <c:out value='${car.engineInformation.engineStatistics.horsepower}'></c:out>
                    </td>
             </tr>
             <tr>
                 <th>Torque: </th>
                     <td>
                        <c:out value='${car.engineInformation.engineStatistics.torque}'></c:out>
                     </td>
             </tr>
             <tr>
                 <th>Fuel Type: </th>
                     <td>
                        <c:out value='${car.fuelInformation.fuelType}'></c:out>
                     </td>
             </tr>
             <tr>
                 <th>City mpg: </th>
                     <td>
                        <c:out value='${car.fuelInformation.cityMpg}'></c:out>
                     </td>
             </tr>
             <tr>
                 <th>Highway mpg: </th>
                     <td>
                        <c:out value='${car.fuelInformation.highwayMpg}'></c:out>
                     </td>
             </tr>
             <tr>
                 <th>Classification: </th>
                     <td>
                        <c:out value='${car.identification.classification}'></c:out>
                     </td>
             </tr>
             <tr>
                 <th>Identification: </th>
                     <td>
                        <c:out value='${car.identification.ID}'></c:out>
                     </td>
             </tr>
             <tr>
                 <th>Make: </th>
                     <td>
                        <c:out value='${car.identification.make}'></c:out>
                     </td>
             </tr>
             <tr>
                 <th>Model & Year: </th>
                     <td>
                        <c:out value='${car.identification.modelYear}'></c:out>
                     </td>
             </tr>
             <tr>
                 <th>Year: </th>
                     <td>
                        <c:out value='${car.identification.year}'></c:out>
                     </td>
             </tr>
    </table>    
</body>

</html>