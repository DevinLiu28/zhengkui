package com.lanou3g.web;

import com.lanou3g.dao.BookDao;
import com.lanou3g.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowBookServlet",urlPatterns = "/showBook")
public class ShowBookServlet extends HttpServlet {
    private BookDao bd = new BookDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        Book book = bd.queryByBookName(name);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/showBook.jsp").forward(request,response);
    }
}
