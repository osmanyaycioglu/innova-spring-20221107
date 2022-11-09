package org.spring.training.innova.advanced.employee.webapp;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/my/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("Filitre devrede");
        String name = request.getParameter("name");
        if ("ali".equals(name)){
            response.getWriter().print("Ali geçemez");
            ((HttpServletResponse)response).setHeader("Content-Type", "text/plain");
        } else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
