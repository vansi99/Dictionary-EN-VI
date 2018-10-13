package controller;

import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.Db;
import model.DbWords;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {


    public WebView browser;

    public Button button;

    public void handleOnClick(){
        System.out.println("si dz nhat!");
        WebEngine webEngine = browser.getEngine();
        DbWords words = new DbWords();

        words.setWord("word");
        try {
            ResultSet rs = words.getDetail();
            while (rs.next()){
                System.out.println(rs.getString("detail"));
                String detail = rs.getString("detail");
                String html = detail ;
                webEngine.loadContent(html);
            }
        } catch (SQLException e){
            System.out.println(e);
        }



    }


}
