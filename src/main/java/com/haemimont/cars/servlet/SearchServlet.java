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

        String model = req.getParameter("model");
        String yearF = req.getParameter("yearF");
        String yearT = req.getParameter("yearT");
        List<Car> listBy = crudServiceCars.searchCarsByParam(model,yearF,yearT);
        req.setAttribute("listBy",listBy);
        RequestDispatcher dispatcher = req.getRequestDispatcher("searchPage.jsp");
        dispatcher.forward(req,resp);

    }
}
