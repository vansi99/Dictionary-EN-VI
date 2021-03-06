package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DbWords;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class Controller {
    public WebView browser;
    public Button button_search;
    public ListView<String> referable_list;
    public DbWords input_word = new DbWords();
    public Button button_add;

    public TextField get_word;

    public void handleOnSearch() {
        WebEngine webEngine = browser.getEngine();
        String inputText = get_word.getText();
        input_word.setWord(inputText);
        System.out.println(inputText);
        String html = input_word.getDetail();
        System.out.println(html);
        if (html == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("Từ này hiện chưa có trong từ điển!");
            alert.showAndWait();
        } else {
            webEngine.loadContent(html);
            referable_list.setItems(null);
        }
    }

    public void showListView(KeyEvent ev) {
        if (ev.getCode() == KeyCode.ENTER) referable_list.setItems(null);
        else {
            String inputText = get_word.getText();
            input_word.setWord(inputText);
            ArrayList<String> list = input_word.getReferWord();
            try {
                ObservableList<String> data = FXCollections.observableArrayList(list);
                System.out.println(data);
                referable_list.setItems(data);
                referable_list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                referable_list.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        get_word.clear();
                        input_word.setWord(referable_list.getSelectionModel().getSelectedItem().toString());
                        get_word.setText(input_word.getWord());
                        WebEngine webEngine = browser.getEngine();
                        String html = input_word.getDetail();
                        webEngine.loadContent(html);
                        referable_list.setItems(null);
                    }
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void setOnKeyPressed(KeyEvent key) {
        if (key.getCode() == KeyCode.ENTER) {
            WebEngine webEngine = browser.getEngine();
            String inputText = get_word.getText();
            input_word.setWord(inputText);
            System.out.println(inputText);
            String html = input_word.getDetail();
            System.out.println(html);
            if (html == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setContentText("Từ này hiện chưa có trong từ điển!");
                alert.showAndWait();
            } else {
                webEngine.loadContent(html);
                referable_list.setItems(null);
            }
        }
    }


    public void handleOnVolume() {
        String inputText = get_word.getText();
        input_word.setWord(inputText);
        System.out.println(inputText);
        try {
            input_word.voiceWord();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void handleOnButtonAdd(ActionEvent event) {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void handleOnButtonEdit(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/View/editWord.fxml")));
            Parent rootEdit = (Parent) fxmlLoader.load();
            Stage stageEdit = new Stage();
            stageEdit.initStyle(StageStyle.UTILITY);

            stageEdit.hide();
            stageEdit.setTitle("Edit Word");
            stageEdit.setScene(new Scene(rootEdit));
            stageEdit.show();
            editController editController = fxmlLoader.getController();
            editController.initEdit(get_word.getText(), input_word.getDetail());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleOnDeleteWord() {
        try {
            WebEngine webEngine = browser.getEngine();
            String inputText = get_word.getText();
            inputText.toLowerCase();
            boolean deleted = input_word.deleteWord(inputText);
            if (deleted) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setContentText("Successs!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setContentText("Có lỗi xảy ra!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleOnButtonGoogleAPI(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("/View/googleAPI.fxml"));
            Parent rootGoogleAPI = (Parent) fxmlLoader.load();

            Stage stageGoogleAPI = new Stage();
            stageGoogleAPI.initStyle(StageStyle.UTILITY);

            stageGoogleAPI.hide();
            stageGoogleAPI.setTitle("Google API");
            stageGoogleAPI.setScene(new Scene(rootGoogleAPI));
            stageGoogleAPI.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

