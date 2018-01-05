package com.lanou3g.web;

import com.lanou3g.dao.BookDao;
import com.lanou3g.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllBooksServlet",urlPatterns = "/showAll")
public class ShowAllBooksServlet extends HttpServlet {
    private BookDao bd = new BookDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
        List<Book> books = bd.showAll();
        request.setAttribute("books",books);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
