
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author sara
 */
public class loginController implements Initializable {
    @FXML
     private TextField userlog;
    String username;
    @FXML
     private TextField passlog;  
    @FXML
    private Button submitButton;    
    public static String username_database;
    public static int ID_database; 
    @FXML
  protected void Login(ActionEvent e)throws IOException { 
      
             
        Window owner = submitButton.getScene().getWindow();
        if(userlog.getText().isEmpty()) {
         showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please Enter your Username");
           return;
        }
        if(passlog.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please Enter a Password");
         return;
        }
        
        
        Session sessionlog = HibernateUtil.getSessionFactory().openSession();
        List<User> sList = null;
        String queryStr = "from User";
        Query query = sessionlog.createQuery(queryStr);
        sList = query.list();
        sessionlog.close();
        username_database=userlog.getText();
                
                
          boolean isfound=false;
         for(User s: sList)
        {
          if(userlog.getText().equals(s.getUserName())&&passlog.getText().equals(s.getPassword()))
          {
              ID_database=s.getID();
              username=userlog.getText();
              isfound=true;
              System.out.println("Successful login");
              Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
              stage.setTitle("Home Page");
              stage.setScene(scene);
              stage.show();
          }
        }
          if(!isfound)  
             showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Wrong username or password,Try again"); 
 }
  
 public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
     Alert alert = new Alert(alertType);
      alert.setTitle(title);
      alert.setHeaderText(null);
      alert.setContentText(message);
      alert.initOwner(owner);
      alert.show();
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
          
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        userlog.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 18));
        userlog.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
        passlog.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 18));
        passlog.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
    }
    
    
}
