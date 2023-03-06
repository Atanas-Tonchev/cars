package com.haemimont.cars.servlet;
import com.haemimont.cars.model.*;
import com.haemimont.cars.service.CRUDService;
import com.haemimont.cars.service.CarService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CarServlet extends HttpServlet {

    CRUDService crudService = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertCar(req, resp);
                    break;
                case "/delete":
                    deleteCar(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                case "/update":
                    updateCar(req, resp);
                    break;
                default:
                    listCar(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        /*int id = Integer.parseInt(req.getParameter("id"));
        String sqlDelete = "DELETE FROM csv_cars_db.login WHERE login_id = ?";

        try {
            Connection connection = ConnectMySqlToTomcat.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlDelete);
            if(id>0) {
                statement.setInt(1, id);
                statement.executeUpdate();
                resp.sendRedirect("deleted.jsp");
                statement.close();
                connection.close();
            }
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

       // sendResponse(resp, "id");
        /*int carID = Integer.parseInt(req.getParameter("id"));
        if (carID != 0) {
            sendResponse(resp, new Gson().toJson(crudService.getCarByID(carID)));
        } else sendResponse(resp,new Gson().toJson(crudService.getAllCars()));*/
        /*String carMake = req.getParameter("make");
        if (carMake != null) {
            sendResponse(resp,new Gson().toJson(crudService.getCarByMake(carMake)));
        } else sendResponse(resp,new Gson().toJson(crudService.getAllCars()));*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
        /*String user = req.getParameter("username");
        String pass = req.getParameter("password");
        String sql = "INSERT INTO csv_cars_db.login(username,password) VALUES(?,?)";

        try {
            Connection connection = ConnectMySqlToTomcat.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user);
            statement.setInt(2,Integer.parseInt(pass));
            statement.executeUpdate();

            resp.sendRedirect("inserted.jsp");
            statement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
*/

    }
    private void listLastCar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        List<Car> listLastCar = crudService.getLastCarInserted();
        request.setAttribute("listCar1",listLastCar);
        RequestDispatcher dispatcher = request.getRequestDispatcher("myCarHomePage.jsp");
        dispatcher.forward(request,response);
    }
    private void listCar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        List<Car> list = crudService.getAllCars();

        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CarList.jsp");
        dispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CarForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car existingCar = crudService.getCarByID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CarForm.jsp");
        request.setAttribute("car", existingCar);
        dispatcher.forward(request, response);

    }

    private void insertCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int dimH = Integer.parseInt(request.getParameter("height"));
        int dimL = Integer.parseInt(request.getParameter("length"));
        int dimW = Integer.parseInt(request.getParameter("width"));
        String driveLine = request.getParameter("drive_line");
        String engineType = request.getParameter("engine_type");
        String hybrid = request.getParameter("hybrid");
        String transmission = request.getParameter("transmission");
        int numOfGears = Integer.parseInt(request.getParameter("number_of_forward_gears"));
        int horsePower = Integer.parseInt(request.getParameter("horsepower"));
        int torque = Integer.parseInt(request.getParameter("torque"));
        String fuelType = request.getParameter("fuel_type");
        int cityMpg = Integer.parseInt(request.getParameter("city_mpg"));
        int highwayMpg = Integer.parseInt(request.getParameter("highway_mpg"));
        String classification = request.getParameter("classification");
        String identificationId = request.getParameter("id");
        String make = request.getParameter("make");
        String modelYear = request.getParameter("model_year");
        int year = Integer.parseInt(request.getParameter("year"));

        Car newCar = new Car(new Dimensions(dimH, dimL, dimW), new EngineInformation(driveLine, engineType, hybrid,
                transmission, numOfGears, new EngineStatistics(horsePower, torque)), new FuelInformation(fuelType,
                cityMpg, highwayMpg), new Identification(classification, identificationId, make, modelYear, year));
        crudService.insertNewCars(newCar);
        response.sendRedirect("list");

    }

    private void updateCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int dimH = Integer.parseInt(request.getParameter("height"));
        int dimL = Integer.parseInt(request.getParameter("length"));
        int dimW = Integer.parseInt(request.getParameter("width"));
        String driveLine = request.getParameter("drive_line");
        String engineType = request.getParameter("engine_type");
        String hybrid = request.getParameter("hybrid");
        String transmission = request.getParameter("transmission");
        int numOfGears = Integer.parseInt(request.getParameter("number_of_forward_gears"));
        int horsePower = Integer.parseInt(request.getParameter("horsepower"));
        int torque = Integer.parseInt(request.getParameter("torque"));
        String fuelType = request.getParameter("fuel_type");
        int cityMpg = Integer.parseInt(request.getParameter("city_mpg"));
        int highwayMpg = Integer.parseInt(request.getParameter("highway_mpg"));
        String classification = request.getParameter("classification");
        String identificationId = request.getParameter("id");
        String make = request.getParameter("make");
        String modelYear = request.getParameter("model_year");
        int year = Integer.parseInt(request.getParameter("year"));

        Car updateCar = new Car(new Dimensions(dimH, dimL, dimW), new EngineInformation(driveLine, engineType, hybrid,
                transmission, numOfGears, new EngineStatistics(horsePower, torque)), new FuelInformation(fuelType,
                cityMpg, highwayMpg), new Identification(classification, identificationId, make, modelYear, year),id);

        crudService.updateCar(updateCar);
        response.sendRedirect("list");

    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Car deleteCar = new Car(id);
        crudService.deleteCar(deleteCar);
        response.sendRedirect("list");

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
