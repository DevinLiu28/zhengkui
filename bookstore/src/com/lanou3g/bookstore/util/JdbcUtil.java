package com.lanou3g.bookstore.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    //Ctrl+Alt+f  把变量变为成员变量
    private static String database;
    private static String url;
    private static String user;
    private static String passWord;
    static {
        try {
            ClassLoader cl = JdbcUtil.class.getClassLoader();
            InputStream inputStream = cl.getResourceAsStream("jdbc.properties");

            Properties prop = new Properties();
            prop.load(inputStream);
            //获得driveName
            String driveName = prop.getProperty("driverName");
            //获得url

            url = prop.getProperty("url");
//            System.out.println(url);
            //获得user
            user = prop.getProperty("user");
            //获得password
            passWord = prop.getProperty("password");
            //获得数据库名
            database = prop.getProperty("database");

            Class.forName(driveName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()+"\n\t\t"+"请将配置文件放置在src目录下");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        //Ctrl+Alt+t
        try {

            Connection conn = DriverManager.getConnection(url+database,user,passWord);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }








    public static void showRS(ResultSet rs){
        try {
            while (rs.next()){
                System.out.print(rs.getString(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.print(rs.getString(4)+"\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
