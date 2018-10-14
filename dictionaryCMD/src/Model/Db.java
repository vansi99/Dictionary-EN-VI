package Model;
import java.sql.*;

public class Db {
    private Connection conn;
    private Statement stmt;
    public Db() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:dictionaryE_V.db");
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
            stmt = null;
            stmt = conn.createStatement();
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

    public boolean postAndDeleteData(String sql) {
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



}