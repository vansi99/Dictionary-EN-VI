package Model;

import java.sql.*;

public class DbWords extends Db {
    private String word;
    private String detail;
    public DbWords(){}

    public DbWords(String word){
        this.word = word;
        this.detail = getDetail();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDetail() {
        String sql = "SELECT detail FROM dictionary WHERE word = '" + word + "'";
        return getData(sql);
    }

    public boolean postWord(String word, String detail){
        if(word == null || detail == null){
            System.out.println("fail");
            return false;
        }
        String sql = "INSERT INTO dictionary(word,detail) VALUES ('" + word +"','"+ detail + "')";
        boolean posted = postData(sql);
        return posted;
    }


}
