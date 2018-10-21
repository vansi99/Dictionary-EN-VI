package controller;

import javafx.scene.control.*;
import model.GoogleApi;

public class googleAPIController extends GoogleApi {
    public TextArea wordGoogleAPI;
    public TextArea detailGoogleAPI;
    public Button button_speaker_API;
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
            recordTextToSpeech(inputText);
            playSoundText();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
