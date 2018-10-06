package com.dict;

import java.sql.*;

public class Db {
    private Connection conn;
    private Statement stsm;
    public Db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost","root","");
            stsm = null;
            stsm = conn.createStatement("create database my_db");
            stsm.executeQuery();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ResultSet getData(String sql,String word) {

        stsm = null;
        try {
            conn.setAutoCommit(false);
            PreparedStatement pstm = null;
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, word);
            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;


    }
}