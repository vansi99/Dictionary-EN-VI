package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Db;
import model.DbWords;
import model.VoiceWord;
import model.*;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;



public class Controller {
    public WebView browser;
    public Button button_search;
    public ListView<String> referable_list;
    public DbWords input_word = new DbWords();
    public Label label;
    public Button button_add_new_word;
    public Button button_add;

    public TextField get_word;

    public void handleOnSearch() {
        WebEngine webEngine = browser.getEngine();
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
            referable_list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            referable_list.setOnMouseClicked (new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    get_word.clear();
                    input_word.setWord(referable_list.getSelectionModel().getSelectedItem().toString());
                    get_word.setText(input_word.getWord());
                    WebEngine webEngine = browser.getEngine();
                    String html = input_word.getDetail();
                    webEngine.loadContent(html);

                }
            });
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void handleOnVolume() {
        String inputText = get_word.getText();
        input_word.setWord(inputText);
        System.out.println(inputText);
        try {
            input_word.voiceWord();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @FXML
    public void handleOnButtonAdd(ActionEvent event){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(this.getClass().getResource("/View/addWord.fxml"));
                Parent rootAdd = (Parent) fxmlLoader.load();

                Stage stageAdd = new Stage();
                stageAdd.initStyle(StageStyle.UTILITY);

                stageAdd.hide();
                stageAdd.setTitle("Add Word");
                stageAdd.setScene(new Scene(rootAdd));
                stageAdd.show();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    @FXML
    public void handleOnButtonEdit(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/View/editWord.fxml")));
            Parent rootEdit = (Parent) fxmlLoader.load();
            editController controller = new editController();
            controller.initEdit();
            Stage stageEdit = new Stage();
            stageEdit.initStyle(StageStyle.UTILITY);

            stageEdit.hide();
            stageEdit.setTitle("Edit Word");
            stageEdit.setScene(new Scene(rootEdit));
            stageEdit.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleOnDeleteWord() {
        try {
        WebEngine webEngine = browser.getEngine();
        String inputText = get_word.getText();
        inputText.toLowerCase();
        boolean deleted = input_word.deleteWord(inputText);
        if (deleted)
            System.out.println("success");
        else System.out.println("fail");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

