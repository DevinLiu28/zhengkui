package com.lanou3g.bookstore.category.dao;

import com.lanou.jdbc.GxQueryRunner;
import com.lanou3g.bookstore.book.dao.BookDao;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.category.domain.Category;
import com.lanou3g.bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    private QueryRunner qr = new GxQueryRunner();
    private BookDao bd = new BookDao();
    public List<Category> findAll() {
        String sql = "select * from category";
        Connection conn = JdbcUtil.getConnection();
        List<Category> categories = null;
        try {
            categories = qr.query(
                    conn,
                    sql,
                    new BeanListHandler<>(Category.class)
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;


    }

    public void add(Category category) {
        String sql =
                "insert into category values(?,?)";

        Connection conn = JdbcUtil.getConnection();
        try {
            qr.update(conn,sql,
                    category.getCid(),
                    category.getCname()
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


    public String findByCname(String cname) {
        String sql = "select * from category where cname=?";
        Connection conn = JdbcUtil.getConnection();
        Category query = null;
        try {
             query = qr.query(
                    conn,
                    sql,
                    new BeanHandler<Category>(Category.class),
                    cname
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query.getCid();




    }

    public String delete(String cid) {
        List<Book> bycid = bd.findBycid(cid);
        System.out.println(cid);
        System.out.println(bycid);
        System.out.println(bycid.size());
        if(bycid.size()!=0){
            System.out.println(bycid);
            return "删除失败";
        }
        String sql = "delete from category where cid=?";
        Connection conn = JdbcUtil.getConnection();
        try {
             qr.update(
                    conn,
                    sql,
                    cid
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
        return "删除成功";
    }

    public Category findByCid(String cid) {

        String sql = "select * from category where cid=?";
        Connection conn = JdbcUtil.getConnection();
        Category query = null;
        try {
            query = qr.query(
                    conn,
                    sql,
                    new BeanHandler<Category>(Category.class),
                    cid
            );

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

    public void edit(Category category) {
        System.out.println(category);
        String sql = "UPDATE category SET cname=? WHERE cid=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            qr.update(
                    conn,
                    sql,
                    category.getCname(),
                    category.getCid()
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
}
