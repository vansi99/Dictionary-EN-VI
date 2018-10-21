package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;
import model.DbWords;

import javax.speech.Word;

public class editController {
    public DbWords editWord = new DbWords();
    public TextField editTextField;
    public HTMLEditor editHtmlMeaning;

    public void initEdit(String word, String detail){
        try {
            editTextField.setText(word);
            editHtmlMeaning.setHtmlText(detail);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void handleOnEditWord(){
        String editInputWord = editTextField.getText();

        String editInputText = editHtmlMeaning.getHtmlText();
        try {
            boolean edited = editWord.updateWord(editInputWord, editInputText);
            if (edited)
                System.out.println("success");
            else System.out.println("fail");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
