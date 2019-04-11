package com.example.root.mytry1.database;

/**
 * Created by root on 19-4-8.
 */

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import retrofit2.http.Query;

public class MysqlConnect {

    private static final String TAG = "MysqlConnect";
    //声明Connection对象
    Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://localhost:3306/mytest";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "1.4141";
    //遍历查询结果集

    public MysqlConnect() {
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Log.i(TAG,"Succeeded connecting to the Database!");
        }
            catch(ClassNotFoundException e) {
                //数据库驱动类异常处理
                System.out.println("Sorry,can`t find the Driver!");
                Log.i(TAG,"Sorry,can`t find the Driver!");

                e.printStackTrace();
            }catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }
    }
    public boolean Query_data(String Email){
        //2.创建statement类对象，用来执行SQL语句！！
        try{
        Statement statement = con.createStatement();
        //要执行的SQL语句
        String sql = "select * from emp";
        //3.ResultSet类，用来存放获取的结果集！！
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("-----------------");
        System.out.println("执行结果如下所示:");
        System.out.println("-----------------");
        System.out.println("姓名" + "\t" + "职称");
        System.out.println("-----------------");

        String job = null;
        String id = null;
        while(rs.next()){
            //获取stuname这列数据
            job = rs.getString("job");
            //获取stuid这列数据
            id = rs.getString("ename");

            //输出结果
            System.out.println(id + "\t" + job);
        }
        rs.close();
        con.close();
    }  catch(SQLException e) {
        //数据库连接失败异常处理
        e.printStackTrace();
    }catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }finally{
        System.out.println("数据库数据成功获取！！");
    }
        return  true;
    }

}