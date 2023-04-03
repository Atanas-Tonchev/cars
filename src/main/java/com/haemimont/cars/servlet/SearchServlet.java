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
import java.util.List;

public class SearchServlet extends HttpServlet {
    CRUDServiceCars crudServiceCars = new CarService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int yearF = Integer.parseInt(req.getParameter("yearF"));
        int yearT = Integer.parseInt(req.getParameter("yearT"));
        List<Car> listByYear = crudServiceCars.getCarByYear(yearF,yearT);
        req.setAttribute("listByYear",listByYear);
        RequestDispatcher dispatcher = req.getRequestDispatcher("carListSearchByYear.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String model = req.getParameter("model");
        List<Car> listByModel = crudServiceCars.getCarByMake(model);
        req.setAttribute("listByModel",listByModel);
        RequestDispatcher dispatcher = req.getRequestDispatcher("carListSearchByModel.jsp");
        dispatcher.forward(req,resp);

    }
}
