package com.haemimont.cars.servlet;
import com.haemimont.cars.api.JarExecutor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
public class JarExecutorServletTestApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("jar") != null && req.getParameter("jar").equals("true")) {
            resp.setContentType("text/plain");
            resp.getWriter().write(JarExecutor.startExtJarProgram().toString());
        }else {
            req.setAttribute("jar", JarExecutor.startExtJarProgram());
            RequestDispatcher dispatcher = req.getRequestDispatcher("apiTests.jsp");
            dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}