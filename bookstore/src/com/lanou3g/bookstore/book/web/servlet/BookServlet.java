package com.lanou3g.bookstore.book.web.servlet;

import com.lanou.servlet.BasicServlet;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.book.service.BookService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BasicServlet {
    private BookService bs = new BookService();
    public void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bs.findAll();
        JSONArray jsonArray = JSONArray.fromObject(books);
        response.getWriter().write(jsonArray.toString());

    }

    public void load(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Book book = bs.findBybid(bid);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/jsps/book/desc.jsp").include(request,response);

    }

    public void category(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("category");
        List<Book> books = bs.findBycid(cid);
        JSONArray jsonArray = JSONArray.fromObject(books);
        response.getWriter().write(jsonArray.toString());


    }
}
