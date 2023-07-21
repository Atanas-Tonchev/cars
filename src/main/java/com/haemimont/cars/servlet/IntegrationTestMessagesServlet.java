package com.haemimont.cars.servlet;
import com.haemimont.cars.api.*;
import com.haemimont.cars.tests.IntegrationTestApi;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class IntegrationTestMessagesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("Username");

        String password = req.getParameter("Password");
        String email = req.getParameter("Email");
        String role = req.getParameter("userTypes");
        List<String> userRoles = new ArrayList<>();
        if (role!=null){
            userRoles.add(role.toLowerCase());
        }
        ApiObjectUtil api = new ApiObjectUtil(new ApiRegistration(username, password, email, userRoles),
                new ApiLogin(username, password), new ApiAuthorization());

        if(username.equals("") && password.equals("")){
            out.println("<font color=red><h1>Please insert username and password for login,</h1></font>"+
                    "<br><font color=red><h1>and username,password,email and role/roles for new registration!</h1></font></br>"+
                    "<br><h1><a href='apiTests.jsp'>Try again</a></h1></br>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("apiTests.jsp");
            rd.include(req, resp);
        }else {
            if (role != null && email != null) {
                try {
                    if (new IntegrationTestApi().whenConnSuccessMakeSingUpSingInCheckAuth(api) == HttpStatus.SC_OK) {
                        // user found.
                        List<String> list = LoggerFile.getLoggApiFile();
                        req.setAttribute("list", list);
                        RequestDispatcher dispatcher = req.getRequestDispatcher("apiTests.jsp");
                        dispatcher.forward(req, resp);
                        resp.sendRedirect("apiTests.jsp");
                    } else {
                        // user not registered.
                        out.println("<font color=red>Either user name or password is wrong.</font>");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("apiTests.jsp");
                        rd.include(req, resp);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else {
                try {
                    if (new IntegrationTestApi().whenConnSuccessMakeSingUpSingInCheckAuth(api) == HttpStatus.SC_OK) {
                        // user found.
                        List<String> list = LoggerFile.getLoggApiFile();
                        req.setAttribute("list", list);
                        RequestDispatcher dispatcher = req.getRequestDispatcher("apiTests.jsp");
                        dispatcher.forward(req, resp);
                        resp.sendRedirect("apiTests.jsp");
                    } else {
                        // user not registered.
                        out.println("<font color=red>Either user name or password is wrong.</font>");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("apiTests.jsp");
                        rd.include(req, resp);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}

