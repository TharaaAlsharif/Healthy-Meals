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
public class HomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        remindTimer();
    }    

    @FXML
    private void Recipes(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("Recipes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Recipes");
        stage.setScene(scene);
        stage.show();        
    }

    @FXML
    private void Planner(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("Planner.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Weekly Meal Planner");
        stage.setScene(scene);
        stage.show();        
    }

    @FXML
    private void Reminder(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("Reminder.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Reminder");
        stage.setScene(scene);
        stage.show();  
        
    }

    @FXML
    private void BMI(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("BMI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("BMI");
        stage.setScene(scene);
        stage.show();        
    }

    @FXML
    private void ShoppingList(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("ShoppingList.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Shopping List");
        stage.setScene(scene);
        stage.show();        
    }

    @FXML
    private void Tips(MouseEvent event) throws IOException{ 
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("Tips.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Tips");
        stage.setScene(scene);
        stage.show();            
    }

    @FXML
    private void LogOut(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Healthy Meals");
        stage.setScene(scene);
        stage.show();
    }
    
}
