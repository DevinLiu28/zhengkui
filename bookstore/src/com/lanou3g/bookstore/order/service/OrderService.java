package com.lanou3g.bookstore.order.service;

import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.cartItem.domain.Cart;
import com.lanou3g.bookstore.cartItem.domain.CartItem;
import com.lanou3g.bookstore.order.dao.OrderDao;
import com.lanou3g.bookstore.order.domain.Order;
import com.lanou3g.bookstore.order.domain.OrderItem;
import com.lanou3g.bookstore.order.service.exception.OrderException;
import com.lanou3g.bookstore.util.RandomId;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderService {

    private OrderDao od = new OrderDao();
    public void add(Order order) {

        order.setOid(RandomId.randomId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());
        order.setOrderTime(format);
        order.setState(0);
        od.addOrder(order);




    }

    public void addOrderItem(Cart cart,Order order) {
        List<OrderItem> orderItems = new ArrayList<>();
        if (cart!=null){
        Map<String, CartItem> cart1 = cart.getCart();
        for (String s : cart1.keySet()) {
            CartItem cartItem = cart1.get(s);
            Book book = cartItem.getBook();
            BigDecimal price = book.getPrice();
            BigDecimal amount = new BigDecimal(cartItem.getAmount());

            OrderItem orderItem = new OrderItem();
            orderItem.setIid(RandomId.randomId());
            orderItem.setCount(Integer.valueOf(cartItem.getAmount()));
            orderItem.setSubtotal(price.multiply(amount));
            orderItem.setOid(order.getOid());
            orderItem.setBid(book.getBid());
            orderItems.add(orderItem);
        }

        od.addOrderItemlist(orderItems);

    }}

    public List<Order> findByUid(String uid) {
        List<Order> byUid = od.findByUid(uid);
        return byUid;

    }

    public Map<Order,List<OrderItem>> findByOid(List<Order> orders) {
        Map<Order,List<OrderItem>> byOid = od.findByOid(orders);
        return byOid;


    }

    public List<OrderItem> findOrderItemByOid(String oid) {
        List<OrderItem> byOid = od.findOrderItemByOid(oid);
        return byOid;
    }

    public Order findByOid(String oid) {
        Order byOid = od.findByOid(oid);
        return byOid;
    }

    public void confirm(String oid) throws OrderException {
        int stateByOid = od.getStateByOid(oid);
        if(stateByOid==1){
            throw new OrderException();
        }else if (stateByOid==0){
            od.updateState(oid,1);
        }


    }
}
