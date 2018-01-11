package com.lanou3g.bookstore.category.admin.web.servlet;

import com.lanou3g.bookstore.user.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/admin/admin.jsp","/admin/book.jsp","/admin/category.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null&&user.getPower()==1){
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect(request.getContextPath()+"/jsps/user/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
