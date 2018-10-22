package model;
import java.sql.*;
import java.util.ArrayList;

public class Db {
    private Connection conn;
    private Statement stmt;
    public Db() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:dictionaryE_V.db");
            stmt = conn.createStatement();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public String getData(String sql) {
        try{
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                String detail = rs.getString("detail");
                rs.close();
                return detail;
            } else return null;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getId(String sql) {
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                int id = rs.getInt("id");
                rs.close();
                stmt.close();
                return id;
            } else return -1;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<String> getReferData(String sql) {
        try{
            ArrayList<String> listReferWord = new ArrayList<>();
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;

            while (rs.next()) {
                String detail = rs.getString("word");
                listReferWord.add(detail);
                i++;
                if(i>=30){
                    break;
                }
            }

            return listReferWord;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteAndCheckData(String sql) {
        try {

            stmt.executeUpdate(sql);
            System.out.println("success");
            return true;
        } catch (SQLException e) {
            System.out.println("fail");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateData(String sql, String word ,String wordNew, String detail){
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, wordNew);
            pstm.setString(2, detail);
            pstm.setString(3, word);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e){
            System.out.println("fail");
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean postData(String sql, String word, String detail){
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, word);
            pstm.setString(2, detail);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e){
            System.out.println("fail");
            System.out.println(e.getMessage());
            return false;
        }

    }



}