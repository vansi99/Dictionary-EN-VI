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

    public void handleOnAddWord(){
        String addInputWord = addTextField.getText();
        String addInputText = addHtmlMeaning.getHtmlText();
        try {
            boolean posted = addNewWord.postWord(addInputWord, addInputText);
            if (posted)
                allertSuccess();
            else allertError();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
