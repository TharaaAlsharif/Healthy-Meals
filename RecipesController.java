/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RecipesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO      
        remindTimer();
    }    
    Timer alarm  = new Timer();
    ObservableList<Timer> listTimer  = FXCollections.observableArrayList();
    public void remindTimer(){
        try {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Reminder.fxml"));
        Parent root;
        root = loader.load();
        Scene scene=new Scene(root);            
        ReminderController p=loader.getController(); 
        if(listTimer.isEmpty()){ 
            listTimer=p.listTimer;        
            alarm=p.alarm;}
        else{
            for (int i = 0 ; i<=listTimer.size()-1;i++){
                listTimer.get(i).getClock().stop();
            }
        
            listTimer=p.listTimer;        
            alarm=p.alarm;            
        }           
        } 
        catch (IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
    public void stop(){
        if(listTimer.isEmpty()){}
        else{
            for (int i = 0 ; i<=listTimer.size()-1;i++){
                listTimer.get(i).getClock().stop();
            }
        }               
    }
    @FXML
    private void dinner(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("dinner.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("dinner");
        stage.setScene(scene);
        stage.show();        
    }

    @FXML
    private void breakfast(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("breakfast.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("breakfast");
        stage.setScene(scene);
        stage.show();        
    }

    @FXML
    private void lunch(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("lunch.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("lunch");
        stage.setScene(scene);
        stage.show();        
    }

    @FXML
    private void snack(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("snack.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("snack");
        stage.setScene(scene);
        stage.show();        
    }
    public void Back(MouseEvent event)throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Healthy Meals");
        stage.setScene(scene);
        stage.show();
    }    
}
