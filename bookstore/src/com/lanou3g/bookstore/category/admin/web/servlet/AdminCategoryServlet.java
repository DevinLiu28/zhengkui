package com.lanou3g.bookstore.category.admin.web.servlet;

import com.lanou.servlet.BasicServlet;
import com.lanou3g.bookstore.cartItem.domain.Cart;
import com.lanou3g.bookstore.category.domain.Category;
import com.lanou3g.bookstore.category.service.CategoryService;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.user.service.UserService;
import com.lanou3g.bookstore.user.service.exception.UserException;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminCategoryServlet",urlPatterns = "/admin")
public class AdminCategoryServlet extends BasicServlet {
    private UserService us = new UserService();
    private CategoryService cs = new CategoryService();
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = new User();
        user.setUsername(request.getParameter("adminname"));
        user.setPassword(request.getParameter("password"));
        try {
            User adminUser = null;
            adminUser = us.login(user);
            request.getSession().setAttribute("adminUser",adminUser);
            System.out.println(adminUser+"111");
        if(adminUser.getPower()==0) {
            response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");
        }else {
            response.sendRedirect(request.getContextPath() + "/adminjsps/admin/index.jsp");
        }


        } catch (UserException e) {
            request.getSession().setAttribute("msg",e.getMessage());
            response.sendRedirect(request.getContextPath()+"/jsps/user/login.jsp");

        }
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Category> all = cs.findAll();
        request.getSession().setAttribute("categorys",all);
        request.getRequestDispatcher("/adminjsps/admin/category/list.jsp").forward(request,response);

    }




    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Category category = new Category();
        try {
            BeanUtils.populate(category,parameterMap);
            cs.add(category);
            request.getSession().setAttribute("delete","添加成功");
            findAll(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        String delete = cs.delete(cname);
        request.getSession().setAttribute("delete",delete);

        findAll(request,response);



    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String cid = request.getParameter("cids");
        Category category = new Category();

        try {
            BeanUtils.populate(category,parameterMap);
            category.setCid(cid);
            cs.edit(category);
            request.getSession().setAttribute("delete","修改成功");
            findAll(request,response);


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }


}
