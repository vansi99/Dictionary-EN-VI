package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import model.DbWords;
import model.GoogleApi;
import model.VoiceWord;

import javax.speech.Word;

public class googleAPIController extends GoogleApi {
    public TextArea wordGoogleAPI;
    public TextArea detailGoogleAPI;
    public GoogleApi outputVoice = new GoogleApi();
    public void handleOnButtonGoogleAPI(){
        try {
            String inputText = wordGoogleAPI.getText();
            System.out.println(inputText);
            detailGoogleAPI.setText(getDetailWord(inputText));
            String detail = detailGoogleAPI.getText();
            System.out.println("\n");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleOnGetVoice(){
        try{
            String inputText = wordGoogleAPI.getText();
            outputVoice.recordTextToSpeech(inputText);
            outputVoice.playSoundText();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
