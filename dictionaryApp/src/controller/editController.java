package controller;

import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;
import model.DbWords;

public class editController {
    public DbWords editWord = new DbWords();
    public TextField editTextField;
    public HTMLEditor editHtmlMeaning;

    public void allertSuccess(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setContentText("Successs!");
        alert.showAndWait();
    }

    public void allertError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alert");
        alert.setContentText("Có lỗi xảy ra!");
        alert.showAndWait();
    }

    public void initEdit(String word, String detail){
        try {
            editTextField.setText(word);
            editHtmlMeaning.setHtmlText(detail);
            editWord.setWord(word);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void handleOnEditWord(){
        String editInputWord = editTextField.getText();
        editWord.setWord(editInputWord);
        System.out.println(editInputWord);
        String editInputText = editHtmlMeaning.getHtmlText();
        System.out.println(editInputText);
        try {
            boolean edited = editWord.updateWord(editInputWord, editInputText);
            if (edited)
                allertSuccess();
            else allertError();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            allertError();
        }

    }
}
