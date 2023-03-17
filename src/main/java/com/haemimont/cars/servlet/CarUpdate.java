package com.haemimont.cars.servlet;
import com.haemimont.cars.model.*;
import com.haemimont.cars.service.CRUDServiceCars;
import com.haemimont.cars.service.CarService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CarUpdate extends HttpServlet {
    CRUDServiceCars crudServiceCars = new CarService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("carId"));
        Car car = crudServiceCars.getCarByID(carId);
        req.setAttribute("car",car);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("CarForm.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Car carUpdate = new Car();
        carUpdate.setId(Integer.parseInt(req.getParameter("id")));
        carUpdate.setDimensions(new Dimensions(Integer.parseInt(req.getParameter("height")),
                Integer.parseInt(req.getParameter("length")),Integer.parseInt(req.getParameter("width"))));
        carUpdate.setEngineInformation(new EngineInformation(req.getParameter("driveLine"),
                req.getParameter("engineType"),req.getParameter("hybrid"),req.getParameter("transmission"),
                Integer.parseInt(req.getParameter("numberOfForwardGears")),new EngineStatistics(
                Integer.parseInt(req.getParameter("horsepower")),Integer.parseInt(req.getParameter("torque")))));
        carUpdate.setFuelInformation(new FuelInformation(req.getParameter("fuelType"),
                Integer.parseInt(req.getParameter("cityMpg")),Integer.parseInt(req.getParameter("highwayMpg"))));
        carUpdate.setIdentification(new Identification(req.getParameter("classification"),req.getParameter("ID"),
                req.getParameter("make"),req.getParameter("modelYear"),Integer.parseInt(req.getParameter("year"))));

        crudServiceCars.updateCar(carUpdate);
        CarServlet carServlet = new CarServlet();
        carServlet.doGet(req,resp);
    }
}
