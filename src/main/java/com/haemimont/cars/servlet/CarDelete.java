package com.haemimont.cars.servlet;

import com.haemimont.cars.service.CRUDServiceCars;
import com.haemimont.cars.service.CarService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

public class CarDelete extends HttpServlet {
    CRUDServiceCars crudServiceCars = new CarService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int carId = Integer.parseInt(req.getParameter("carId"));
        if(crudServiceCars.deleteCar(carId)) {
            out.println("<font color=red>Error delete. Please try again.</font>");
        }else {
            resp.sendRedirect("deleteSuccess.jsp");
        }

    }
}
