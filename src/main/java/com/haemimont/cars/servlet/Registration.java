package com.haemimont.cars.servlet;

import com.haemimont.cars.service.CRUDServiceUsers;
import com.haemimont.cars.service.UsersService;
import com.haemimont.cars.users.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Registration extends HttpServlet {
    CRUDServiceUsers crudServiceUsers = new UsersService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pass = req.getParameter("password");
        User user = new User(username,pass);
        crudServiceUsers.insertUser(user);
        resp.sendRedirect("success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
