package com.lanou3g.bookstore.user.dao;

import com.lanou.jdbc.GxQueryRunner;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Userdao {
    private QueryRunner qr = new GxQueryRunner();
    public void updateState(String uid,int state){
        String sql = "UPDATE tb_user SET state=? WHERE uid=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            qr.update(
                    conn,
                    sql,
                    state,
                    uid
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

    public User findByCode(String code){
        String sql = "select * from tb_user where code = ?";
        Connection conn = JdbcUtil.getConnection();
        User user = null;
        try {
            user = qr.query(
                    conn,
                    sql,
                    new BeanHandler<User>(User.class),
                    code
            );
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    public User findByUsername(String username){
        String sql = "select * from tb_user where username = ?";
        Connection conn = JdbcUtil.getConnection();
        User user = null;
        try {
            user = qr.query(
                    conn,
                    sql,
                    new BeanHandler<User>(User.class),
                    username
            );
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;

    }

    public User findByEmail(String email){
        String sql = "select * from tb_user where email = ?";
        Connection conn = JdbcUtil.getConnection();
        User user = null;
        try {
            user = qr.query(
                    conn,
                    sql,
                    new BeanHandler<User>(User.class),
                    email
            );
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    public void add(User form){
        String sql =
                "insert into tb_user values(?,?,?,?,?,?)";

        Connection conn = JdbcUtil.getConnection();
        try {
            qr.update(conn,sql,
                    form.getUid(),
                    form.getUsername(),
                    form.getPassword(),
                    form.getEmail(),
                    form.getCode(),
                    0);
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
