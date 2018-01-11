package com.lanou3g.bookstore.order.dao;

import com.lanou.jdbc.GxQueryRunner;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.order.domain.Order;
import com.lanou3g.bookstore.order.domain.OrderItem;
import com.lanou3g.bookstore.util.JdbcUtil;
import com.lanou3g.bookstore.util.RandomId;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDao {
    private QueryRunner qr = new GxQueryRunner();

    public void addOrder(Order order) {
        String sql =
                "insert into orders values(?,?,?,?,?,?)";

        Connection conn = JdbcUtil.getConnection();
        try {
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            ts=Timestamp.valueOf(order.getOrderTime());
            qr.update(conn,sql,
                    order.getOid(),
                    ts,
                    order.getTotal(),
                    order.getState(),
                    order.getUid(),
                    order.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void addOrderItemlist(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            String sql =
                    "insert into orderitem values(?,?,?,?,?)";

            Connection conn = JdbcUtil.getConnection();
            try {

                qr.update(conn,sql,
                        orderItem.getIid(),
                        orderItem.getCount(),
                        orderItem.getSubtotal(),
                        orderItem.getOid(),
                        orderItem.getBid());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }



        }
    }

    public List<Order> findByUid(String uid) {


            String sql = "select * from orders where uid=?";
            Connection conn = JdbcUtil.getConnection();
            List<Order> orders =null;
            try {
                 orders = qr.query(
                        conn,
                        sql,
                        new BeanListHandler<>(Order.class),
                        uid
                );
                 conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Map<Order,List<OrderItem>> findByOid(List<Order> orders) {

//        List<Map<Order,List<OrderItem>>> lists = new ArrayList<>();
        Map<Order,List<OrderItem>> map = new HashMap<>();
        for (Order order : orders) {
            String sql = "select * from orderitem where oid=?";
            Connection conn = JdbcUtil.getConnection();
            List<OrderItem> list =null;
            try {
                list = qr.query(
                        conn,
                        sql,
                        new BeanListHandler<>(OrderItem.class),
                        order.getOid()
                );
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            map.put(order,list);
//            lists.add(map);
        }
        return map;


    }

    public List<OrderItem> findOrderItemByOid(String oid) {
        String sql = "select * from orderitem where oid=?";
        Connection conn = JdbcUtil.getConnection();
        List<OrderItem> query = null;
        try {
             query = qr.query(
                    conn,
                    sql,
                    new BeanListHandler<>(OrderItem.class),
                    oid
            );
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;



    }

    public Order findByOid(String oid) {
        String sql = "select * from orders where oid=?";
        Connection conn = JdbcUtil.getConnection();
        Order query = null;
        try {
             query = qr.query(
                    conn,
                    sql,
                    new BeanHandler<>(Order.class),
                    oid
            );
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public int getStateByOid(String oid) {
        String sql = "select state from orders where oid=?";
        Connection conn = JdbcUtil.getConnection();
        Order query = null;
        try {
             query = qr.query(
                    conn,
                    sql,
                    new BeanHandler<Order>(Order.class),
                    oid
            );
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query.getState();



    }

    public void updateState(String oid, int state) {
        String sql = "UPDATE orders SET state=? WHERE oid=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            qr.update(
                    conn,
                    sql,
                    state,
                    oid
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public List<Book> findBybid(String oid) {
//        List<Book> books = new ArrayList<>();
//        for (OrderItem book : orderItems) {
//            String sql = "select * from book where bid=?";
//            Connection conn = JdbcUtil.getConnection();
//            Book book1 = new Book();
//            try {
//                qr.query(
//                        conn,
//                        sql,
//                        new BeanHandler<Book>(Book.class),
//                        book.getBid()
//                );
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            books.add(book1);
//        }
//        return books;
//
//    }
}
