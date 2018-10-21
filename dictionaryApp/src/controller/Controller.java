package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.Db;
import model.DbWords;
import model.GoogleApi;
import model.VoiceWord;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    public WebView browser;
    public Button button_search;
    public TextField get_word;
    public ListView<String> referable_list;
    public DbWords input_word = new DbWords();

    public void handleOnSearch() {
        WebEngine webEngine = browser.getEngine();
        GoogleApi x = new GoogleApi();
        try {
            x.recordTextToSpeech();
            x.playSoundText();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        String inputText = get_word.getText();
        input_word.setWord(inputText);
        System.out.println(inputText);
        String html = input_word.getDetail();
        webEngine.loadContent(html);

    }

    public void showListView() {
        String inputText = get_word.getText();
        input_word.setWord(inputText);
        ArrayList<String> list = input_word.getReferWord();
        try {
            ObservableList<String> data = FXCollections.observableArrayList(list);
            System.out.println(data);
            referable_list.setItems(data);
            referable_list.getSelectionModel().selectedItemProperty().addListener(
                    (ObservableValue<? extends String> ov, String old_val,
                     String new_val) -> {
                        System.out.println(new_val);
                    });
            referable_list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void handleOnVolume() {
        String inputText = get_word.getText();
        input_word.setWord(inputText);
        System.out.println(inputText);
        try {
            input_word.voiceWord();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

