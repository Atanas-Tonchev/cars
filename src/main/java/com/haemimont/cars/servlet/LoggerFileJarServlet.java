package com.haemimont.cars.servlet;
import com.haemimont.cars.api.ApiPathConfiguration;
import com.haemimont.cars.api.LoggerFile;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
public class LoggerFileJarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String logg = req.getParameter("logg");
        if (logg != null && logg.equals("true")) {
            resp.setContentType("text/plain");
            resp.getWriter().write(LoggerFile.getLoggJarFile(ApiPathConfiguration.PATH_JAR_LOGGER_FILE).toString());
        }else {
            req.setAttribute("logg", LoggerFile.getLoggJarFile(ApiPathConfiguration.PATH_JAR_LOGGER_FILE));
            RequestDispatcher dispatcher = req.getRequestDispatcher("apiTests.jsp");
            dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
