package com.lanou3g.bookstore.book.dao;

import com.lanou.jdbc.GxQueryRunner;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new GxQueryRunner();
    public List<Book> findAll(){
        String sql = "select * from book";
        Connection conn = JdbcUtil.getConnection();
        List<Book> books = null;
        try {
             books = qr.query(
                    conn,
                    sql,
                    new BeanListHandler<>(Book.class)
            );
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book findBybid(String bid) {
        String sql = "select * from book where bid=?";
        Connection conn = JdbcUtil.getConnection();
        Book book = new Book();
        try {
             book = qr.query(
                     conn,
                     sql,
                     new BeanHandler<Book>(Book.class),
                     bid
                     );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> findBycid(String cid) {
        String sql = "select * from book where cid=?";
        Connection conn = JdbcUtil.getConnection();
        List<Book> books=null;
        try {
             books = qr.query(
                    conn,
                    sql,
                    new BeanListHandler<>(Book.class),
                    cid
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;

    }
}
