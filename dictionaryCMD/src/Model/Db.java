package Model;
import java.sql.*;

public class Db {
    private Connection conn;
    private Statement stmt;
    public Db() {
        try {
            Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:dictionaryE_V.db");
                System.out.println("Connection to SQLite has been established.");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ResultSet getData(String sql) {
        try{
            stmt = null;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean postData(String sql) {
        try {
            stmt = null;
            stmt= conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("success");
            return true;
        } catch (SQLException e) {
            System.out.println("fail");
            System.out.println(e.getMessage());
            return false;
        }
    }

//    public boolean deleteData(String sql){
//        try {
//            stmt = null;
//            stmt= conn.createStatement();
//            stmt.executeUpdate(sql);
//            System.out.println("success");
//            return true;
//        } catch (SQLException e) {
//            System.out.println("fail");
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }



}