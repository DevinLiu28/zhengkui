package com.lanou3g.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserDao ud = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        if (username.equals("")||password.equals("")){
//            RequestDispatcher dispatcher  = request.getRequestDispatcher("/register.html");
//            dispatcher.forward(request,response);
//        }else {
//            User user = new User(null, username, password);
//            ud.insert(user);
//            response.sendRedirect("http://localhost:8080/login.html");
//        }
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
            User user1 = ud.queryByUsername(user.getUsername());

            if(user1==null){
                //可以注册
                if (user.getPassword()==null||user.getPassword().equals("")){
                    //注册成功
                    ud.insert(user);
                    response.sendRedirect("http://localhost:8080/login.html");
                    return;
                }else {
                    //注册失败
                }
            }else {
                //注册失败
            }
            request.getRequestDispatcher("/register.html").forward(request,response);





        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
