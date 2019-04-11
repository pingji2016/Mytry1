package com.example.root.mytry1.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import android.util.Base64;

/**
 * Created by root on 19-4-1.
 */

public class MySqlConnection{

    private static String driver = "com.mysql.cj.jdbc.Driver";//MySQL 驱动
    //private static String url = "jdbc:mysql://39.97.97.254:3306/mysql?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    //MYSQL数据库连接Url
    //url=jdbc:mysql://127.0.0.1:3306/mybatis?useUnicode=true&serverTimezone=GMT&characterEncoding=utf8&useSSL=true
    //yinliu?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true
    //test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
    private static String url = "jdbc:mysql://localhost:3306/mysql";
    //?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC

    private static String user = "root";//用户名
    private static String password = "1.4141";//密码

    /**
     * 连接数据库
     * */

    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName(driver);//获取MYSQL驱动
            conn = (Connection) DriverManager.getConnection(url, user, password);//获取连接
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭数据库
     * */

    public static void closeAll(Connection conn, PreparedStatement ps){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 关闭数据库
     * */

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

