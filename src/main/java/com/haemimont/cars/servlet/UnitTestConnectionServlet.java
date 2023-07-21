package com.haemimont.cars.servlet;
import com.haemimont.cars.api.LoggerFile;
import com.haemimont.cars.tests.UnitTestApi;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpStatus;
import java.io.IOException;
import java.util.List;

public class UnitTestConnectionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (new UnitTestApi().getConnectionTest() == HttpStatus.SC_OK) {
            List<String> list = LoggerFile.getLoggApiFile();
            req.setAttribute("loggApi", list);
            RequestDispatcher dispatcher = req.getRequestDispatcher("apiTests.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("apiTests.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("apiTests.jsp");
            rd.include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
