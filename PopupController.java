/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PopupController implements Initializable {
    private MediaPlayer mediaPlayer;
    @FXML
    private Button Popupbutton;
    @FXML
    private Label PopupTitlemsg;
    @FXML
    private Label PopupTimemsg;
    @FXML
    private Label PopupDatemsg;
    public String getPopupTitlemsg() {
        return PopupTitlemsg.getText();
    }

    public void setPopupTitlemsg(String PopupTitlemsg) {
        this.PopupTitlemsg.setText(PopupTitlemsg); 
    }

    public String getPopupTimemsg() {
        return PopupTimemsg.getText();
    }

    public void setPopupTimemsg(String PopupTimemsg) {
        this.PopupTimemsg.setText(PopupTimemsg); 
    }

    public String getPopupDatemsg() {
        return PopupDatemsg.getText();
    }

    public void setPopupDatemsg(String PopupDatemsg) {
        this.PopupDatemsg.setText(PopupDatemsg); 
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
      void Alarm(){
       Media media = new Media(getClass().getResource("sound/alarm.wav").toString());
       mediaPlayer = new MediaPlayer(media);       
       mediaPlayer.play(); 
    }
    @FXML
    private void PopupButton(ActionEvent event) {
        mediaPlayer.stop(); 
        ((Node)(event.getSource())).getScene().getWindow().hide();         
    }
    
}
