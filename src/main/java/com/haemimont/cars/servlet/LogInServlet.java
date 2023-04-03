package com.haemimont.cars.servlet;
import com.haemimont.cars.service.CRUDServiceUsers;
import com.haemimont.cars.service.UsersService;
import com.haemimont.cars.users.User;
import com.haemimont.cars.utils.EncryptionPass;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class LogInServlet extends HttpServlet {
    CRUDServiceUsers crudServiceUsers = new UsersService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("Username");
        String pass = EncryptionPass.MD5(req.getParameter("Password"));
        User userCheck = new User(username, pass);

        if (crudServiceUsers.loginCheck(userCheck)) {

            // user found.
            Cookie loginCookie = new Cookie("Username",username);
            loginCookie.setMaxAge(15*60);
            resp.addCookie(loginCookie);
            resp.sendRedirect("welcome.jsp");
            /*RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
            rd.forward(req, resp);*/
        } else {
            // user not registered.
            out.println("<font color=red>Either user name or password is wrong.</font>");
            out.println("<p>Please try again ! <a href=\"login.html\" class=\"create\">Login</a></p>");
            out.println("<p>Not registered ? <a href=\"registration.html\">Create an account</a></p>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("login.html");
            rd.include(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
