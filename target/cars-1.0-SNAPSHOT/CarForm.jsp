<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="editBtn.css" />
<html>
<head>
    <title>Cars Store Application</title>
    <style>
      tr:hover td {
      background-color: #696969;
      color: white;
        }
    </style>
</head>
<body style="background-position: center;background-size:cover;" background="pics/wallpaperflare.com_wallpaper.jpg">
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
    <center style="color: #C71585;">
        <h1>Cars Management</h1>
        <form action="CarServlet" align="center">
            <input type="submit" class="btn" value="All"  >
         </form>
    </center>
    <div align="center" onchange="toggleDiv(this.value)">
        <c:if test="${car != null}">
            <form action="CarServlet" method="post">
        </c:if>
        <c:if test="${car == null}">
            <form action="CarServlet" method="post">
        </c:if>
        <table style="background-position: center;background-size:cover;" background="pics/wallpaperflare.com_wallpaper.jpg"  border="1" cell-padding="2">
            <caption>
                <h2 style="color: #800000;">
                    <c:if test="${car != null}">
                        Edit Car
                    </c:if>
                    <c:if test="${car == null}">
                        Add New Car
                    </c:if>
                </h2>
            </caption>
                <c:if test="${car != null}">
                    <input type="hidden" name="id" value="<c:out value='${car.id}' />" />
                </c:if>
                 <tr>
                    <th>Dimensions Height: </th>
                       <td>
                           <input type="text" name="height" size="5"
                           value="<c:out value='${car.dimensions.height}' />"
                           />
                       </td>
                 </tr>
                 <tr>
                    <th>Dimensions Length: </th>
                       <td>
                          <input type="text" name="length" size="5"
                          value="<c:out value='${car.dimensions.length}' />"
                          >
                       </td>
                 </tr>
                 <tr>
                    <th>Dimensions Width: </th>
                        <td>
                           <input type="text" name="width" size="5"
                           value="<c:out value='${car.dimensions.width}' />"
                           >
                        </td>
                 </tr>
                 <tr>
                    <th>Drive Line: </th>
                        <td>
                            <input type="text" name="driveLine" size="45"
                            value="<c:out value='${car.engineInformation.driveLine}' />"
                            >
                        </td>
                 </tr>
                 <tr>
                    <th>Engine Type: </th>
                        <td>
                            <input type="text" name="engineType" size="45"
                            value="<c:out value='${car.engineInformation.engineType}' />"
                            >
                        </td>
                 </tr>
                 <tr>
                     <th>Hybrid: </th>
                        <td>
                            <input type="text" name="hybrid" size="5"
                            value="<c:out value='${car.engineInformation.hybrid}' />"
                            >
                        </td>
                 </tr>
                 <tr>
                     <th>Transmission: </th>
                        <td>
                            <input type="text" name="transmission" size="45"
                            value="<c:out value='${car.engineInformation.transmission}' />"
                            >
                        </td>
                 </tr>
                 <tr>
                     <th>Number of forward gears: </th>
                        <td>
                            <input type="text" name="numberOfForwardGears" size="5"
                            value="<c:out value='${car.engineInformation.numberOfForwardGears}' />"
                            >
                        </td>
                 </tr>
                 <tr>
                     <th>Horsepower: </th>
                        <td>
                            <input type="text" name="horsepower" size="5"
                            value="<c:out value='${car.engineInformation.engineStatistics.horsepower}' />"
                            >
                        </td>
                 </tr>
                 <tr>
                     <th>Torque: </th>
                         <td>
                            <input type="text" name="torque" size="5"
                            value="<c:out value='${car.engineInformation.engineStatistics.torque}' />"
                            >
                         </td>
                 </tr>
                 <tr>
                     <th>Fuel Type: </th>
                         <td>
                            <input type="text" name="fuelType" size="45"
                            value="<c:out value='${car.fuelInformation.fuelType}' />"
                            >
                         </td>
                 </tr>
                 <tr>
                     <th>City mpg: </th>
                         <td>
                            <input type="text" name="cityMpg" size="5"
                            value="<c:out value='${car.fuelInformation.cityMpg}' />"
                            >
                         </td>
                 </tr>
                 <tr>
                     <th>Highway mpg: </th>
                         <td>
                             <input type="text" name="highwayMpg" size="5"
                             value="<c:out value='${car.fuelInformation.highwayMpg}' />"
                             >
                         </td>
                 </tr>
                 <tr>
                     <th>Classification: </th>
                         <td>
                             <input type="text" name="classification" size="45"
                             value="<c:out value='${car.identification.classification}' />"
                             >
                         </td>
                 </tr>
                 <tr>
                     <th>Identification: </th>
                         <td>
                             <input type="text" name="ID" size="45"
                             value="<c:out value='${car.identification.ID}' />"
                             >
                         </td>
                 </tr>
                 <tr>
                     <th>Make: </th>
                         <td>
                             <input type="text" name="make" size="45"
                             value="<c:out value='${car.identification.make}' />"
                             >
                         </td>
                 </tr>
                 <tr>
                     <th>Model & Year: </th>
                         <td>
                             <input type="text" name="modelYear" size="45"
                             value="<c:out value='${car.identification.modelYear}' />"
                             >
                         </td>
                 </tr>
                 <tr>
                     <th>Year: </th>
                         <td>
                             <input type="text" name="year" size="5"
                             value="<c:out value='${car.identification.year}' />"
                             >
                         </td>
                 </tr>
                 <tr>
                    <td colspan="5" align="center">
                        <input class="btn" type="submit" value = "Save" />
                        <input type="reset" class="btn1" value="Reset">
                    </td>
                </tr>
        </table>
        </form>
    </div>
    <script>
        function toggleDiv(value){
            //if no selection
            if(value == ""){
                alert("Please select an option");
            }
        }
    </script>
</body>

</html>
