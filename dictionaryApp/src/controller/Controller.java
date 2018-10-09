package controller;

import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.DbWords;
import java.sql.ResultSet;

public class Controller extends DbWords{

//    ResultSet rs = getDetails("hello");
//    if(rs.next()) {
//        System.out.println("nghia cua tu la:" + rs.getString("detail"));
//    }
    public WebView browser;

    public Button button;

    public void handleOnClick(){
        System.out.println("si dz nhat!");
        WebEngine webEngine = browser.getEngine();
        String html = "<html><i>hello /hə'lou/ (halloa) /hə'lou/ (hello) /'he'lou/</i><br/><ul><li><b><i> thán từ</i></b><ul><li><font color='#cc0000'><b> chào anh!, chào chị!</b></font></li></ul><ul><li><font color='#cc0000'><b> này, này</b></font></li></ul><ul><li><font color='#cc0000'><b> ô này! (tỏ ý ngạc nhiên)</b></font><ul></li></ul></ul></li></ul><ul><li><b><i> danh từ</i></b><ul><li><font color='#cc0000'><b> tiếng chào</b></font></li></ul><ul><li><font color='#cc0000'><b> tiếng gọi \"này, này\" !</b></font></li></ul><ul><li><font color='#cc0000'><b> tiếng kêu ô này \"! (tỏ ý ngạc nhiên)</b></font><ul></li></ul></ul></li></ul><ul><li><b><i> nội động từ</i></b><ul><li><font color='#cc0000'><b> chào</b></font></li></ul><ul><li><font color='#cc0000'><b> gọi \"này, này\"</b></font></li></ul><ul><li><font color='#cc0000'><b> kêu \"ô này\" (tỏ ý ngạc nhiên)</b></font></li></ul></li></ul></html>";
        webEngine.loadContent(html);
    }


}
