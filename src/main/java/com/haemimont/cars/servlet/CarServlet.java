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
import java.util.List;


public class CarServlet extends HttpServlet {

    CRUDServiceCars crudService = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> list = crudService.getAllCars();
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("carList.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int dimH = Integer.parseInt(req.getParameter("height"));
        int dimL = Integer.parseInt(req.getParameter("length"));
        int dimW = Integer.parseInt(req.getParameter("width"));
        String driveLine = req.getParameter("driveLine");
        String engineType = req.getParameter("engineType");
        String hybrid = req.getParameter("hybrid");
        String transmission = req.getParameter("transmission");
        int numOfGears = Integer.parseInt(req.getParameter("numberOfForwardGears"));
        int horsePower = Integer.parseInt(req.getParameter("horsepower"));
        int torque = Integer.parseInt(req.getParameter("torque"));
        String fuelType = req.getParameter("fuelType");
        int cityMpg = Integer.parseInt(req.getParameter("cityMpg"));
        int highwayMpg = Integer.parseInt(req.getParameter("highwayMpg"));
        String classification = req.getParameter("classification");
        String identificationId = req.getParameter("ID");
        String make = req.getParameter("make");
        String modelYear = req.getParameter("modelYear");
        int year = Integer.parseInt(req.getParameter("year"));

        Car newCar = new Car(new Dimensions(dimH, dimL, dimW), new EngineInformation(driveLine, engineType, hybrid,
                transmission, numOfGears, new EngineStatistics(horsePower, torque)), new FuelInformation(fuelType,
                cityMpg, highwayMpg), new Identification(classification, identificationId, make, modelYear, year));

        crudService.insertCar(newCar);
        doGet(req,resp);
        resp.sendRedirect("list");
    }
}
