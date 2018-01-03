package com.lanou3g.dao;

import com.lanou3g.bean.User;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private QueryRunner qr = new QueryRunner();
//    public void insert(User user){
//        String username = user.getUsername();
//        String password = user.getPassword();
//        String sql = "insert into users values(null,?,?)";
//        Connection conn = JdbcUtil.getConnection();
//        try {
//            qr.update(
//                    conn,
//                    sql,
//                    username,
//                    password);
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public List<User> login(){
        String sql = "select * from users";
        Connection conn = JdbcUtil.getConnection();
        try {
            List<User> users = qr.query(
                    conn,
                    sql,
                    new BeanListHandler<>(User.class)
            );
            conn.close();
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }



    public User queryByUsername(String username){
        String sql = "select * from users where username = ?";
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

        return user;
    }



    public void insert(User user) {
        String sql =
                "insert into users values(null,?,?)";

        Connection conn = JdbcUtil.getConnection();
        try {
            qr.update(conn,sql,user.getUsername(),user.getPassword());
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
