package com.haemimont.cars.servlet;
import com.haemimont.cars.api.ApiAuthorization;
import com.haemimont.cars.api.ApiLogin;
import com.haemimont.cars.api.ApiObjectUtil;
import com.haemimont.cars.api.ApiRegistration;
import com.haemimont.cars.tests.ApiReceivingMessages;
import com.haemimont.cars.tests.TestApiConnRegLoginAuth;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class IntegrationTestMessagesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestApiConnRegLoginAuth test = new TestApiConnRegLoginAuth();
        ApiReceivingMessages receivingMessages = new ApiReceivingMessages();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String user = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        List<String> userRoles = new ArrayList<>();
        userRoles.add(req.getParameter("userType").toLowerCase());
        ApiObjectUtil api = new ApiObjectUtil(new ApiRegistration(user, password, email, userRoles),
                new ApiLogin(user, password), new ApiAuthorization());

        try {
            if (test.whenConnSuccessMakeSingUpSingInCheckAuth(api)==200) {
                // user found.
                List<String> list = receivingMessages.getMap();
                req.setAttribute("list", list);
                RequestDispatcher dispatcher = req.getRequestDispatcher("resultTestMessages.jsp");
                dispatcher.forward(req,resp);
                Cookie loginCookie = new Cookie("username1",user);
                loginCookie.setMaxAge(15*60);
                resp.addCookie(loginCookie);
                resp.sendRedirect("resultTestMessages.jsp");
            } else {
                // user not registered.
                out.println("<font color=red>Either user name or password is wrong.</font>");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("processInputApiTestMessages.jsp");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

