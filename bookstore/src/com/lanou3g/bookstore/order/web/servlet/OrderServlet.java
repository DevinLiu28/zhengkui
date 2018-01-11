package com.lanou3g.bookstore.order.web.servlet;

import com.lanou.servlet.BasicServlet;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.book.service.BookService;
import com.lanou3g.bookstore.cartItem.dao.CartDao;
import com.lanou3g.bookstore.cartItem.domain.Cart;
import com.lanou3g.bookstore.order.domain.Order;
import com.lanou3g.bookstore.order.domain.OrderItem;
import com.lanou3g.bookstore.order.service.OrderService;
import com.lanou3g.bookstore.order.service.exception.OrderException;
import com.lanou3g.bookstore.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BasicServlet {
    private OrderService os = new OrderService();
    private CartDao cd = new CartDao();
    private BookService bs = new BookService();
    public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        String total = request.getParameter("total");
        Order order = new Order();
        BigDecimal bigDecimal = new BigDecimal(total);
        order.setTotal(bigDecimal);
        User user = (User)request.getSession().getAttribute("user");
        order.setUid(user.getUid());
        os.add(order);
        request.getSession().setAttribute("order",order);
        os.addOrderItem(cart, order);
        request.getSession().setAttribute("ordercart",cart);
        request.getSession().setAttribute("cart",new Cart());
        response.sendRedirect(request.getContextPath()+"/jsps/order/desc.jsp");
    }
    public void myOrders(HttpServletRequest request,HttpServletResponse response) throws IOException {

        List<Book> books = bs.findAll();
        request.getSession().setAttribute("books",books);
        User user = (User)request.getSession().getAttribute("user");
        List<Order> order = os.findByUid(user.getUid());
        Map<Order,List<OrderItem>> orders = os.findByOid(order);
        request.getSession().setAttribute("orderitem",orders);
        response.sendRedirect(request.getContextPath()+"/jsps/order/list.jsp");

    }

    public void load(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        List<OrderItem> byOid = os.findOrderItemByOid(oid);
        request.setAttribute("byoid",byOid);
        Order order = os.findByOid(oid);
        request.getSession().setAttribute("order",order);
        request.getRequestDispatcher("/jsps/order/desc.jsp").include(request,response);

    }


    public void confirm(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String oid = request.getParameter("oid");
        try {
            os.confirm(oid);
            request.setAttribute("msg","已确认收货");
            request.getRequestDispatcher("/jsps/order/list.jsp").include(request,response);
        } catch (OrderException e) {
            request.getSession().setAttribute("msg",e.getMessage());
            response.sendRedirect(request.getContextPath()+"/jsps/msg.jsp");
        }


    }


}
