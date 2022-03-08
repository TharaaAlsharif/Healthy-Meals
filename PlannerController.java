/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;


import static healthymeals.loginController.ID_database;
import java.io.IOException;
import java.net.URL;
import static healthymeals.loginController.username_database;
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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
/**
 * FXML Controller class
 *
 * @author user
 */
public class PlannerController implements Initializable {

    @FXML
    private TextArea txa1=new TextArea(" ");
    @FXML
    private TextArea txa2=new TextArea(" ");
    @FXML
    private TextArea txa3=new TextArea(" ");
    @FXML
    private TextArea txa4=new TextArea(" ");
    @FXML
    private TextArea txa5=new TextArea(" ");
    @FXML
    private TextArea txa6=new TextArea(" ");
    @FXML
    private TextArea txa7=new TextArea(" ");
    @FXML
    private TextArea txa8=new TextArea(" ");
    @FXML
    private TextArea txa9=new TextArea(" ");
    @FXML
    private TextArea txa10=new TextArea(" ");
    @FXML
    private TextArea txa11=new TextArea(" ");
    @FXML
    private TextArea txa12=new TextArea(" ");
    @FXML
    private TextArea txa13=new TextArea(" ");
    @FXML
    private TextArea txa14=new TextArea(" ");
    @FXML
    private TextArea txa15=new TextArea(" ");
    @FXML
    private TextArea txa16=new TextArea(" ");
    @FXML
    private TextArea txa17=new TextArea(" ");
    @FXML
    private TextArea txa18=new TextArea(" ");
    @FXML
    private TextArea txa19=new TextArea(" ");
    @FXML
    private TextArea txa20=new TextArea(" ");
    @FXML
    private TextArea txa21=new TextArea(" ");
    @FXML
    private TextArea txa22=new TextArea(" ");
    @FXML
    private TextArea txa23=new TextArea(" ");
    @FXML
    private TextArea txa24=new TextArea(" ");
    @FXML
    private TextArea txa25=new TextArea(" ");
    @FXML
    private TextArea txa26=new TextArea(" ");
    @FXML
    private TextArea txa27=new TextArea(" ");
    @FXML
    private TextArea txa28=new TextArea(" ");
    MealPlanner[][]p;
    /**
     * Initializes the controller class.
     */
    //int id ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remindTimer(); 
        txa1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa1.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa2.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa3.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa4.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa4.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa5.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa5.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa6.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa6.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa7.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa7.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa8.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa8.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa9.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa9.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa10.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa10.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;"); 
        txa11.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa11.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa12.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa12.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa13.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa13.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa14.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa14.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa15.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa15.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa16.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa16.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa17.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa17.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa18.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa18.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa19.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa19.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa20.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa20.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");  
        txa21.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa21.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa22.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa22.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa23.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa23.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa24.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa24.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa25.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa25.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa26.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa26.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa27.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa27.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        txa28.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        txa28.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        
        MealPlanner[][]Planner_DB = {{new MealPlanner (ID_database+"a_Breakfast",txa1.getText(),txa2.getText(),txa3.getText(),txa4.getText(),txa5.getText(),txa6.getText(),txa7.getText())},
        {new MealPlanner(ID_database+"b_Lunch",txa8.getText(),txa9.getText(),txa10.getText(),txa11.getText(),txa12.getText(),txa13.getText(),txa14.getText()) },
        {new MealPlanner(ID_database+"c_Snack",txa15.getText(),txa16.getText(),txa17.getText(),txa18.getText(),txa19.getText(),txa20.getText(),txa21.getText())},
        {new MealPlanner(ID_database+"d_Dinner",txa22.getText(),txa23.getText(),txa24.getText(),txa25.getText(),txa26.getText(),txa27.getText(),txa28.getText())}};        
        temp=Planner_DB ;   
        
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<MealPlanner> mpList = null;
        String queryStr = "from MealPlanner";
        Query query = session1.createQuery(queryStr);
        mpList = query.list();
        session1.close();
        int i = 0;
        for(MealPlanner m: mpList){
            if(m.getUsername().equals(username_database)){
                
            if(i==0){
                txa1.setText(m.getSunday());
                txa2.setText(m.getMonday());
                txa3.setText(m.getTuesday());
                txa4.setText(m.getWedneday());
                txa5.setText(m.getThursday());
                txa6.setText(m.getFriday());
                txa7.setText(m.getSaturday());
            }
            if(i==1){
                txa8.setText(m.getSunday());
                txa9.setText(m.getMonday());
                txa10.setText(m.getTuesday());
                txa11.setText(m.getWedneday());
                txa12.setText(m.getThursday());
                txa13.setText(m.getFriday());
                txa14.setText(m.getSaturday());                
            }
            if(i==2){
                txa15.setText(m.getSunday());
                txa16.setText(m.getMonday());
                txa17.setText(m.getTuesday());
                txa18.setText(m.getWedneday());
                txa19.setText(m.getThursday());
                txa20.setText(m.getFriday());
                txa21.setText(m.getSaturday());                
            }
            if(i==3){
                txa22.setText(m.getSunday());
                txa23.setText(m.getMonday());
                txa24.setText(m.getTuesday());
                txa25.setText(m.getWedneday());
                txa26.setText(m.getThursday());
                txa27.setText(m.getFriday());
                txa28.setText(m.getSaturday());   
            }
            i++;
            if(i==5){break;}
            }
            if(!m.getUsername().equals(username_database)){p=null;}
            else{p=temp; }              
        }
    }    
MealPlanner[][]temp;
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
    
    @FXML
    
    private void Save(MouseEvent event) {
        MealPlanner[][]NewPlanner = {{new MealPlanner (ID_database+"a_Breakfast",txa1.getText(),txa2.getText(),txa3.getText(),txa4.getText(),txa5.getText(),txa6.getText(),txa7.getText())},
                            {new MealPlanner(ID_database+"b_Lunch",txa8.getText(),txa9.getText(),txa10.getText(),txa11.getText(),txa12.getText(),txa13.getText(),txa14.getText()) },
                            {new MealPlanner(ID_database+"c_Snack",txa15.getText(),txa16.getText(),txa17.getText(),txa18.getText(),txa19.getText(),txa20.getText(),txa21.getText())},
                            {new MealPlanner(ID_database+"d_Dinner",txa22.getText(),txa23.getText(),txa24.getText(),txa25.getText(),txa26.getText(),txa27.getText(),txa28.getText())}};        
        if(p==null){
            p = temp;
            for(int i = 0;i <=NewPlanner.length-1;i++){ 
                NewPlanner[i][0].setUsername(username_database);
                delete(NewPlanner[i][0]);
                database(NewPlanner[i][0]);
            }
        }
        else{
            for(int i = 0;i <=NewPlanner.length-1;i++){ 
                NewPlanner[i][0].setUsername(username_database);
                update(NewPlanner[i][0]);
            }            
        }
    }
    
    public void update(MealPlanner p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.evict(p);
        session.update(p);
        tx.commit();
        session.close();        
    }    
    public void database(MealPlanner p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.evict(p);
        String mp = (String)session.save(p);
        tx.commit();
        session.close();        
    }
    @FXML
    private void clear(MouseEvent  event) {
        if (p==null){
            for(int j = 0;j <=temp.length-1;j++){ 
                temp[j][0].setUsername(username_database);
                delete(temp[j][0]);
            } 
        }
        else{
            for(int j = 0;j <=p.length-1;j++){
                temp[j][0].setUsername(username_database);
                delete(p[j][0]);
            } 
            p=null;
        }      
        txa1.setText(" ");txa2.setText(" ");txa3.setText(" ");txa4.setText(" ");txa5.setText(" ");txa6.setText(" ");txa7.setText(" ");
        txa8.setText(" ");txa9.setText(" ");txa10.setText(" ");txa11.setText(" ");txa12.setText(" ");txa13.setText(" ");txa14.setText(" ");
        txa15.setText(" ");txa16.setText(" ");txa17.setText(" ");txa18.setText(" ");txa19.setText(" ");txa20.setText(" ");txa21.setText(" ");
        txa22.setText(" ");txa23.setText(" ");txa24.setText(" ");txa25.setText(" ");txa26.setText(" ");txa27.setText(" ");txa28.setText(" ");                
    }
    public void delete(MealPlanner p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        p.setUsername(username_database);
        session.delete(p);
        tx.commit();
        session.close(); 
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
}
