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
            <a href="./CarServlet/new">Add New Car</a>
            &nbsp;&nbsp;&nbsp;
            <a href="./CarServlet/list">List All Cars</a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${car != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${car == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cell-padding="5">
            <caption>
                <h2>
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
                           <input type="text" name="height" size="45"
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
                                            <input type="text" name="driveLine" size="5"
                                            value="<c:out value='${car.engineInformation.driveLine}' />"
                                            >
                                         </td>
                                  </tr>
                 <tr>
                                     <th>Engine Type: </th>
                                         <td>
                                            <input type="text" name="engineType" size="5"
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
                                            <input type="text" name="transmission" size="5"
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
                                            <input type="text" name="fuelType" size="5"
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
                                            <input type="text" name="classification" size="5"
                                            value="<c:out value='${car.identification.classification}' />"
                                            >
                                         </td>
                                  </tr>
                 <tr>
                                     <th>Identification: </th>
                                         <td>
                                            <input type="text" name="ID" size="5"
                                            value="<c:out value='${car.identification.ID}' />"
                                            >
                                         </td>
                                  </tr>
                 <tr>
                                     <th>Make: </th>
                                         <td>
                                            <input type="text" name="make" size="5"
                                            value="<c:out value='${car.identification.make}' />"
                                            >
                                         </td>
                                  </tr>
                 <tr>
                                     <th>Model & Year: </th>
                                         <td>
                                            <input type="text" name="modelYear" size="5"
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
                    <td col-span="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
        </table>
        </form>
    </div>
</body>
</html>