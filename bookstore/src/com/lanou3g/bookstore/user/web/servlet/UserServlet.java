package com.lanou3g.bookstore.user.web.servlet;

import com.lanou.servlet.BasicServlet;
import com.lanou3g.bookstore.cartItem.domain.Cart;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.user.service.UserService;
import com.lanou3g.bookstore.user.service.exception.UserException;
import com.lanou3g.bookstore.util.sendemail.Sendmail;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BasicServlet {
    private UserService us = new UserService();
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);

            User dbUser = us.login(user);
            request.getSession().setAttribute("user",dbUser);
            request.getSession().setAttribute("cart",new Cart());
            if(dbUser.getPower()==0) {
                response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");
            }else {
                response.sendRedirect(request.getContextPath() + "/adminjsps/admin/index.jsp");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (UserException e) {
            request.getSession().setAttribute("msg",e.getMessage());
            response.sendRedirect(request.getContextPath()+"/jsps/user/login.jsp");
        }

    }

    public void regist(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
            user = us.regist(user);
            Sendmail.sendmail(user);
            request.getSession().setAttribute("user",user);
//          request.getRequestDispatcher("/jsps/msg.jsp");
            response.sendRedirect(request.getContextPath()+"/jsps/user/regist.jsp");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (UserException e) {
            request.getSession().setAttribute("user",user);
            request.getSession().setAttribute("exception",e.getMessage());
            response.sendRedirect(request.getContextPath()+"/jsps/user/regist.jsp");
        }

    }
    public void active(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        String s = us.request(code);
        request.getSession().setAttribute("msg",s);
        response.sendRedirect(request.getContextPath()+"/jsps/msg.jsp");
    }

    public void quit(HttpServletRequest request,HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
//        System.out.println(session.getAttribute("msg"));
        session.invalidate();
        //System.out.println(session.getAttribute("user"));
//        if (session==null){
            response.sendRedirect(request.getContextPath()+"/jsps/user/login.jsp");
//        }else {
//            System.out.println(session.getAttributeNames().toString());
//        }
    }

}
