package sample;
import java.sql.*;

public class DbWords extends Db{
    public ResultSet getDetails(String word){
        return getData("SELECT detail FROM my_db WHERE word = ?",word);
    }
}
