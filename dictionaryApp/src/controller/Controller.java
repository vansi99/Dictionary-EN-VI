package controller;

import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.Db;
import model.DbWords;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {


    public WebView browser;

    public Button button;

    public void handleOnClick(){
        System.out.println("si dz nhat!");
        WebEngine webEngine = browser.getEngine();
        DbWords words = new DbWords();
//        if(words.postWord("dicksi", "đít")){
//            System.out.println("post success");
//        } else System.out.println("post fail");
        words.setWord("dicksi");
        try {
            ResultSet rs = words.getDetail();
            while (rs.next()){
                System.out.println(rs.getString("detail"));
            }
        } catch (SQLException e){
            System.out.println(e);
        }

        String html = "<html><i>hello /hə'lou/ (halloa) /hə'lou/ (hello) /'he'lou/</i><br/><ul><li><b><i> thán từ</i></b><ul><li><font color='#cc0000'><b> chào anh!, chào chị!</b></font></li></ul><ul><li><font color='#cc0000'><b> này, này</b></font></li></ul><ul><li><font color='#cc0000'><b> ô này! (tỏ ý ngạc nhiên)</b></font><ul></li></ul></ul></li></ul><ul><li><b><i> danh từ</i></b><ul><li><font color='#cc0000'><b> tiếng chào</b></font></li></ul><ul><li><font color='#cc0000'><b> tiếng gọi \"này, này\" !</b></font></li></ul><ul><li><font color='#cc0000'><b> tiếng kêu ô này \"! (tỏ ý ngạc nhiên)</b></font><ul></li></ul></ul></li></ul><ul><li><b><i> nội động từ</i></b><ul><li><font color='#cc0000'><b> chào</b></font></li></ul><ul><li><font color='#cc0000'><b> gọi \"này, này\"</b></font></li></ul><ul><li><font color='#cc0000'><b> kêu \"ô này\" (tỏ ý ngạc nhiên)</b></font></li></ul></li></ul></html>";
        webEngine.loadContent(html);
    }


}
