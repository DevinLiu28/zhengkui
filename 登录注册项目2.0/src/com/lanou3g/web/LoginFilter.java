package com.lanou3g.web;

import com.lanou3g.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/index.jsp","/showBook.jsp","/register","/showAll","/showBook"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
