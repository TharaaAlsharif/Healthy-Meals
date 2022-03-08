/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLController implements Initializable {
@FXML
     private ImageView img1;
     
     @FXML
     private ImageView img2;
      
     @FXML
     private ImageView img3;
       
     @FXML
     private ImageView img4;
          
     @FXML
     private ImageView img5;
         
     @FXML
     private ImageView img6;


    /**
     * Initializes the controller class.
     */
     //https://www.youtube.com/watch?v=MgD2FxMr7AA
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       TranslateTransition transition1 = new TranslateTransition();
       transition1.setDuration (Duration. seconds (1));
       transition1.setToY(-15);
       transition1.setAutoReverse(true);
       transition1.setCycleCount(Animation.INDEFINITE);
       transition1.setNode (img1);
       transition1.play();
       
       TranslateTransition transition2 = new TranslateTransition();
       transition2.setDuration (Duration. seconds (1));
       transition2.setToY(15);
       transition2.setAutoReverse(true);
       transition2.setCycleCount(Animation.INDEFINITE);
       transition2.setNode (img2);
       transition2.play();
       
       TranslateTransition transition3 = new TranslateTransition();
       transition3.setDuration (Duration. seconds (1));
       transition3.setToY(-15);
       transition3.setAutoReverse(true);
       transition3.setCycleCount(Animation.INDEFINITE);
       transition3.setNode (img3);
       transition3.play();
       
       
       TranslateTransition transition4 = new TranslateTransition();
       transition4.setDuration (Duration. seconds (1));
       transition4.setToY(15);
       transition4.setAutoReverse(true);
       transition4.setCycleCount(Animation.INDEFINITE);
       transition4.setNode (img4);
       transition4.play();

       
       TranslateTransition transition5 = new TranslateTransition();
       transition5.setDuration (Duration. seconds (1));
       transition5.setToY(-15);
       transition5.setAutoReverse(true);
       transition5.setCycleCount(Animation.INDEFINITE);
       transition5.setNode (img5);
       transition5.play();
       
       TranslateTransition transition6 = new TranslateTransition();
       transition6.setDuration (Duration. seconds (1));
       transition6.setToY(-15);
       transition6.setAutoReverse(true);
       transition6.setCycleCount(Animation.INDEFINITE);
       transition6.setNode (img6);
       transition6.play();        
    } 
    @FXML
    private void LogInButton(ActionEvent e)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Log In");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void HomePage(ActionEvent e)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }   
    @FXML
    private void SignUpButton(ActionEvent e)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    }    
}
