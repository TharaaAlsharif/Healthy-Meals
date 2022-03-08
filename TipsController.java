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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aw0010
 */
public class TipsController implements Initializable {

    @FXML
    private Button btPrev;
    @FXML
    private Button btNext;
    @FXML
    private TextArea taTips;

    /**
     * Initializes the controller class.
     */
    String [] arrTips = new String[] {
        "Tip 1:\nInclude a fruit or vegetable at every meal.",
        "Tip 2:\nMake your kids smoothies once a week.",
        "Tip 3:\nTake a walk after dinner.",
        "Tip 4:\nReplace juices with water.",
        "Tip 5:\nUse extra virgin oil instead of vegetable oil.",
        "Tip 6:\nEat a handful of nuts each day.",
        "Tip 7:\nChoose snacks that provide energy.",
        "Tip 8:\nYou should avoid serving fast foods to children.",
        "Tip 9:\nDon't force your child to eat if he doesn't want to.",
        "Tip 10:\nTurn off the TV and any other electronic devices while eating."
    };
    int i =0;
    
public void initialize(URL url, ResourceBundle rb) {
    remindTimer();
        taTips.setText("Tip 1:\nInclude a fruit or vegetable at every meal");
        taTips.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        taTips.setStyle("-fx-font-alignment: center;");
        taTips.setStyle("-fx-text-fill: #eda1bd;");
        btPrev.setOnAction(e->{
            i--;
            if(i<0){
                i=arrTips.length-1;
                taTips.setText(arrTips[i]);
            }
            else{
                if(i>=arrTips.length-1){
                    i=arrTips.length;
                    taTips.setText(arrTips[i]);
                }
                taTips.setText(arrTips[i]);
            }
        });
        
        btNext.setOnAction(e->{
            i++;
            if(i>arrTips.length-1){
                i=0;
                taTips.setText(arrTips[i]); 
                //i++;
            }
            else{
                taTips.setText(arrTips[i]);
            }
        });
        taTips.setOnKeyPressed(e->{
            if(e.getCode()== KeyCode.RIGHT){
               taTips.setText(arrTips[i]); 
            if(i>=arrTips.length-1){
                i=0;
                taTips.setText(arrTips[i]); 
                i++;
            }
            else{
                i++;
                taTips.setText(arrTips[i]);
            }
           
            }
            
            else if(e.getCode()== KeyCode.LEFT){
                i--;
            if(i<0){
                i=arrTips.length-1;
                taTips.setText(arrTips[i]);
            }
            else{
                if(i>=arrTips.length-1){
                    i=arrTips.length;
                    taTips.setText(arrTips[i]);
                }
                taTips.setText(arrTips[i]);
            }            
            }
       });
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
    private void Back(MouseEvent event) throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Healthy Meals");
        stage.setScene(scene);
        stage.show();        
    }
        
}
        
    
    

