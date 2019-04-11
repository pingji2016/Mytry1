package com.example.root.mytry1.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by root on 19-4-2.
 */

public class QueryDatabase {
    private Connection conn = null;

    /*
    * 查询操作
    * */
    private ResultSet execSQL(String sql, Object... args) throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement(sql);
        for(int i = 0; i < args.length; i++){
            pStmt.setObject(i+1, args[i]);
        }
        pStmt.execute();
        return pStmt.getResultSet();
    }
    public boolean SetConnection (Connection c){
        if (c==null) return false;
        conn=c;
        return true;
    }
    /*
    * 判断密码用户是否正确
    * */
    public boolean Check_Usr(String username,String password){
        ResultSet rs = null;
        String sql="select * from login_user";
        sql+="where name="+username;
        try {
            rs = execSQL(sql);
        } catch (SQLException e) {
            System.err.println("查询数据库出错");
            e.printStackTrace();
            return false;
        }
        try {
            while(rs.next()){
                String temp_username = rs.getString("user_name").trim();
                String temp_password = rs.getString("password").trim();
                if (password.equals(temp_password)){
                    return  true;
                }
            }
        } catch (SQLException e) {
            System.err.println("操作ResultSet出错");
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;

    }

    public void closeSQLConn(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
