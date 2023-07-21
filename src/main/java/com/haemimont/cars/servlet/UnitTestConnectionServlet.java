package com.haemimont.cars.servlet;
import com.haemimont.cars.api.LoggerAndJarExecutorConfiguration;
import com.haemimont.cars.api.SingletonLoggerFile;
import com.haemimont.cars.tests.UnitTestApi;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnitTestConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new UnitTestApi().getConnectionTest();
        req.setAttribute("test", SingletonLoggerFile.getLoggFile(LoggerAndJarExecutorConfiguration.PATH_API_LOGGER_FILE));
        RequestDispatcher dispatcher = req.getRequestDispatcher("apiTests.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
