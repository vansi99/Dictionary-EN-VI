package controller;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.Db;
import model.DbWords;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {


    public WebView browser;
    public Button button_search;
    public TextField get_word;
    public ListView<String> referable_list ;

    public void handleOnSearch(){
        WebEngine webEngine = browser.getEngine();
        String text = get_word.getText();
        get_word.setText(text);
        System.out.println(text);
        String html = "<html><i>zymurgy</i><br/><ul><li><b><i> danh từ</i></b><ul><li><font color='#cc0000'><b> khoa nghiên cứu sự lên men</b></font></li></ul></li></ul></html>";
        webEngine.loadContent(html);
    }

    public void showListView(){
        referable_list.getItems().addAll("Iron Man", "Harry Potter", "Percy Jackson");
        referable_list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }









//    public Button button;
//
//    public void handleOnClick(){
//        System.out.println("si dz nhat!");
//        WebEngine webEngine = browser.getEngine();
//        DbWords words = new DbWords();
//        words.setWord("word");
//        try {
//            ResultSet rs = words.getDetail();
//            while (rs.next()){
//                System.out.println(rs.getString("detail"));
//                String detail = rs.getString("detail");
//                String html = detail;
//                webEngine.loadContent(html);
//            }
//        } catch (SQLException e){
//            System.out.println(e);
//        }



    }



