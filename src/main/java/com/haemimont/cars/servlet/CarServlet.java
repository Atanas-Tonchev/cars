package com.haemimont.cars.servlet;
import com.google.gson.Gson;
import com.haemimont.cars.service.CRUDService;
import com.haemimont.cars.service.CarService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


public class CarServlet extends HttpServlet {

    CRUDService crudService = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int carID = Integer.parseInt(req.getParameter("id"));
        if (carID != 0) {
            sendResponse(resp, new Gson().toJson(crudService.getCarByID(carID)));
        } else sendResponse(resp,new Gson().toJson(crudService.getAllCars()));
       /* String carMake = req.getParameter("make");
        if (carMake != null) {
            sendResponse(resp,new Gson().toJson(crudService.getCarByMake(carMake)));
        } else sendResponse(resp,new Gson().toJson(crudService.getAllCars()));*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
    private void sendResponse(HttpServletResponse response, String payload) {
        try {
            OutputStream out = response.getOutputStream();
            out.write(payload.getBytes());
            out.flush();
        }
        catch(Exception e) {
            throw new RuntimeException(Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
        }
    }
}
