package model;

import java.sql.*;

public class DbWords extends Db {
    private String word;
    private ResultSet referWord;
    private ResultSet detail;
    public DbWords(){}

    public DbWords(String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDetail(ResultSet detail) {
        this.detail = detail;
    }

    public ResultSet getReferWord() {
        String sql = "SELECT word FROM dictionary WHERE word LIKE '" + word + "%'";
        referWord = getData(sql);
        return referWord;
    }

    public ResultSet setDetailAndId() {
        String sql = "SELECT detail,id FROM dictionary WHERE word = '" + word + "'";
        ResultSet result = getData(sql);

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
