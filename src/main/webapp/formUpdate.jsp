<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cars</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CreateAndFind">Cars List</a>
        </li>
      </ul>
      <form action="CreateAndFind" method="GET" class="d-flex">
        <input name="search" class="form-control me-2" type="search" placeholder="" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<br>
<div class="container">
	<div class="row">
		<div class="cold-md-7">
			<hr>
			<h3>Update Car</h3>
			<hr>
			<form action="CarUpdate" method="POST">
					<input value="${car.id}" name="id" type="number" style="visibility:hidden">
					<div class="form-floating mb-3">
						<input value="${car.dimensions.height}" name="height" maxlength="5" type="text" class="form-control">
						<label>Dimensions Height:</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${car.dimensions.length}" name="length" maxlength="5" type="text" class="form-control">
                        <label>Dimensions Length:</label>
					</div>
					<div class="form-floating mb-3">
                 		<input value="${car.dimensions.width}" name="width" maxlength="5" type="text" class="form-control">
                        <label>Dimensions Width:</label>
                    </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.engineInformation.driveLine}" name="drive_line" maxlength="45" type="text" class="form-control">
                                            <label>Drive Line:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.engineInformation.engineType}" name="engine_type" maxlength="45" type="text" class="form-control">
                                            <label>Engine Type:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.engineInformation.hybrid}" name="hybrid" maxlength="5" type="text" class="form-control">
                                            <label>Hybrid:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.engineInformation.transmission}" name="transmission" maxlength="45" type="text" class="form-control">
                                            <label>Transmission:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.engineInformation.numberOfForwardGears}" name="number_of_forward_gears" maxlength="5" type="text" class="form-control">
                                            <label>Number of forward gears:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.engineInformation.engineStatistics.horsepower}" name="horsepower" maxlength="5" type="text" class="form-control">
                                            <label>Horsepower:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.engineInformation.engineStatistics.torque}" name="torque" maxlength="5" type="text" class="form-control">
                                            <label>Torque:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.fuelInformation.fuelType}" name="fuel_type" maxlength="45" type="text" class="form-control">
                                            <label>Fuel Type:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.fuelInformation.cityMpg}" name="city_mpg" maxlength="5" type="text" class="form-control">
                                            <label>City mpg:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.fuelInformation.highwayMpg}" name="highway_mpg" maxlength="5" type="text" class="form-control">
                                            <label>Highway mpg:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.identification.classification}" name="classification" maxlength="45" type="text" class="form-control">
                                            <label>Classification:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.identification.ID}" name="ID" maxlength="45" type="text" class="form-control">
                                            <label>Identification:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.identification.make}" name="make" maxlength="45" type="text" class="form-control">
                                            <label>Make:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.identification.modelYear}" name="model_year" maxlength="45" type="text" class="form-control">
                                            <label>Model & Year:</label>
                                        </div>
                    <div class="form-floating mb-3">
                                     		<input value="${car.identification.year}" name="year" maxlength="5" type="text" class="form-control">
                                            <label>Year:</label>
                                        </div>

					<button class="btn btn-success" type="submit">Submit</button>
					<button class="btn btn-secondary" type="reset">Reset</button>
			</form>
			<br>
		</div>

	</div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>