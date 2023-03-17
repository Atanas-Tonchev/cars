package com.haemimont.cars.servlet;
import com.haemimont.cars.service.CRUDServiceUsers;
import com.haemimont.cars.service.UsersService;
import com.haemimont.cars.users.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    CRUDServiceUsers crudServiceUsers = new UsersService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("Username");
        String pass = req.getParameter("Password");
        User userCheck = new User(username,pass);

        if (crudServiceUsers.loginCheck(userCheck)) {
            // user found.
            RequestDispatcher rd = req.getRequestDispatcher("/CarServlet");
            rd.forward(req, resp);
        } else {
            // user not registered.
            out.println("Invalid Name or Password");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, resp);
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
