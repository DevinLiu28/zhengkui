package com.lanou3g.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao ud = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
            User u = ud.queryByUsername(user.getUsername());
            if(u==null){
                //登录失败
            }else {
                if(u.getPassword().equals(user.getPassword())){
                    //登录成功
                    request.getSession().setAttribute("user",user);
                    response.sendRedirect("http://localhost:8080/index.jsp");
                    return;
                }else {
                    //登录失败
                }
            }
            request.getRequestDispatcher("/login1.jsp").forward(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
