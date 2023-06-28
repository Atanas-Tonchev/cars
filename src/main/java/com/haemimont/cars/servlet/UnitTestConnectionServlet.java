package com.haemimont.cars.servlet;
import com.haemimont.cars.tests.TestApiConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnitTestConnectionServlet extends HttpServlet {
    TestApiConnection testApiConnection = new TestApiConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("test") != null && req.getParameter("test").equals("true")) {
            resp.setContentType("text/plain");
            resp.getWriter().write(testApiConnection.getConnectionTest());
        } else {
            req.setAttribute("test", testApiConnection.getConnectionTest());
            RequestDispatcher dispatcher = req.getRequestDispatcher("testConnectionResult.jsp");
            dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
