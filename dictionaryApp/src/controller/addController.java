package controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;
import model.DbWords;

public class addController {

    public DbWords addNewWord = new DbWords();
    public TextField addTextField;
    public HTMLEditor addHtmlMeaning;

    public void handleOnAddWord(){
        String addInputWord = addTextField.getText();
        String addInputText = addHtmlMeaning.getHtmlText();
        try {
            boolean posted = addNewWord.postWord(addInputWord, addInputText);
            if (posted)
                System.out.println("success");
            else System.out.println("fail");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
