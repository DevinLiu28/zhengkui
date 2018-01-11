package com.lanou3g.bookstore.category.web.servlet;

import com.lanou.servlet.BasicServlet;
import com.lanou3g.bookstore.category.domain.Category;
import com.lanou3g.bookstore.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BasicServlet {
    private CategoryService cs = new CategoryService();
    public void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = cs.findAll();
        request.getSession().setAttribute("categories",categories);
        request.getRequestDispatcher("/jsps/left.jsp").include(request,response);


    }
}
