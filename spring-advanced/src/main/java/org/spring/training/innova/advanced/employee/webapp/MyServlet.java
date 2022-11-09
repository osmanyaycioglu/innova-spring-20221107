package org.spring.training.innova.advanced.employee.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/my/servlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.getWriter().print(name);
        resp.setHeader("Content-Type","text/plain");
    }
}
