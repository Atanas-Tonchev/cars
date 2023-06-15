package com.haemimont.cars.servlet;
import com.haemimont.cars.funny.JokesAppClient;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JokesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("refresh")!= null && req.getParameter("refresh").equals("true")) {
            resp.setContentType("text/plain");
            resp.getWriter().write(getJoke());
        } else {
            req.setAttribute("value", getJoke());
            RequestDispatcher dispatcher = req.getRequestDispatcher("jokes.jsp");
            dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public String getJoke() {
        String result;
        try {
            result = new JokesAppClient().syncGson();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
