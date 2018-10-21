package model;

import java.sql.*;
import java.util.ArrayList;

public class DbWords extends Db {
    private String word;
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

    public boolean checkWordHad(String word) {
        String sql = "SELECT id FROM dictionary WHERE word = '" + word + "'";
        if (getId(sql) == -1) return false;
        else return true;
    }


    public String getDetail() {
        String sql = "SELECT detail FROM dictionary WHERE word = '" + word + "'";
        return getData(sql);
    }

    public ArrayList<String> getReferWord() {
        String sql = "SELECT word FROM dictionary WHERE word LIKE '" + word + "%'";
        return getReferData(sql);
    }

    public boolean postWord(String word, String detail){
        if(word == null || detail == null){
            System.out.println("fail");
            return false;
        }

        if(checkWordHad(word) == false) {
            String sql = "INSERT INTO dictionary(word,detail) VALUES ('" + word + "','" + detail + "')";
            boolean posted = postUpdateDeleteData(sql);
            return posted;
        } else {
            System.out.println("Từ này đã có trong từ điển");
            return false;
        }

    }

    public boolean updateWord(String wordNew, String detail) {
        String sql = "UPDATE dictionary SET word = '" + wordNew + "', detail = '" + detail + "' WHERE word = '" + this.word + "'";
        return postUpdateDeleteData(sql);
    }


    public boolean deleteWord(String word){
        if(word == null){
            System.out.println("fail");
            return false;
        }
        String sql = "DELETE FROM dictionary WHERE word = '" + word + "'";
        boolean deleted = postUpdateDeleteData(sql);
        return deleted;
    }

    public void voiceWord() throws Exception {
        VoiceWord su = new VoiceWord();
        su.init("kevin16");
        su.doSpeak(word);

    }


}
