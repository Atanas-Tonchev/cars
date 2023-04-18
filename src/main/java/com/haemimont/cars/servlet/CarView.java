package com.haemimont.cars.servlet;

import com.haemimont.cars.model.Car;
import com.haemimont.cars.service.CRUDServiceCars;
import com.haemimont.cars.service.CarService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CarView extends HttpServlet {
    CRUDServiceCars crudServiceCars = new CarService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int carId = Integer.parseInt(req.getParameter("carId"));
        Car car = crudServiceCars.getCarByID(carId);
        req.setAttribute("car",car);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewCar.jsp");
        requestDispatcher.forward(req,resp);
    }

}
