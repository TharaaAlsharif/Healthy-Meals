package healthymeals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import com.jfoenix.controls.JFXDatePicker;
import java.util.List;
import java.util.Locale;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 96655
 */
public class SignUpController implements Initializable {
    
Session session = HibernateUtil.getSessionFactory().openSession();
public static int c = 0 ;   
@FXML
private TextField fristname;
@FXML
private JFXDatePicker childbirth;
@FXML
private TextField username;
@FXML
private TextField lastname;
@FXML
private RadioButton Male;
@FXML
private RadioButton Female;
@FXML
private TextField password;
@FXML
private ToggleGroup gender;
@FXML
private Button submitButton2; 
 
    
  @FXML
   public void sign(ActionEvent event) throws IOException {
      Window owner = submitButton2.getScene().getWindow();
          User sign1=new User(); 

        
         if(fristname.getText().isEmpty()||lastname.getText().isEmpty())
          { showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please Enter your Fristname and Lastname");}
         
         else if(username.getText().isEmpty())  
         {  showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please Enter your Username");}
              
         else if  (password.getText().isEmpty()||password.getText().length()<8)
          { showAlert(Alert.AlertType.ERROR, owner, "Form Error!","The length of password number must be 8 digits at least");}
         
         else
          {
             int id=0;
             
           Session sessionlog = HibernateUtil.getSessionFactory().openSession();
           List<User> sList = null;
           String queryStr = "from User";
           Query query = sessionlog.createQuery(queryStr);
           sList = query.list();
           sessionlog.close();
           for(User s: sList)
           {
               id =s.getID();
              //c++;
             if(username.getText().equalsIgnoreCase(s.getUserName())){
             {showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Username already exists, choose another one!!!");}
             }   
              
          }    
                   //  showAlert(Alert.AlertType.INFORMATION, owner, "confirmation","Your account has been successfully created");    

          sign1.setFName(fristname.getText());
          sign1.setLName(lastname.getText());
          sign1.setPassword(password.getText());
          sign1.setUserName(username.getText());
          
          sign1.setChildBirth(childbirth.getValue()+"");
          if(Male.isSelected())
          sign1.setChildGender(Male.getText());
          else if(Female.isSelected())
          sign1.setChildGender(Female.getText());
          c=id+1;
          sign1.setID(c);
     try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(sign1);
        tx.commit();
        session.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();        
        }
     catch(Exception e)
      { 
       System.out.println("The User exists in the database");
      } 
      }
    }
          
    
   @FXML
   public void LogOut(MouseEvent e)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Healthy Meals");
        stage.setScene(scene);
        stage.show();
   }
   public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
     Alert alert = new Alert(alertType);
      alert.setTitle(title);
      alert.setHeaderText(null);
      alert.setContentText(message);
      alert.initOwner(owner);
      alert.show();
      
    }
          
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        Locale.setDefault(Locale.ENGLISH);   
        fristname.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 18));
        fristname.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        
        username.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 18));
        username.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        
        lastname.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lastname.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        
        password.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 18));
        password.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");        
    }
    
    
}



