/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import static healthymeals.loginController.username_database;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReminderController implements Initializable {
    @FXML
    private JFXDatePicker date; 
    @FXML
    private JFXTimePicker time  ;   
    @FXML
    private TextField title ;
    @FXML
    private ListView<String> lvalarm;
    @FXML
    private ListView<TextField> lvtext;
    @FXML
    private Label lblmsg;
    ObservableList<String> obalarm = FXCollections.observableArrayList(); 
    ObservableList<TextField> obtext = FXCollections.observableArrayList();
    ObservableList<Timer> listTimer  = FXCollections.observableArrayList();
    Timer alarm = new Timer();
    TextField text;
    @FXML
    public void Back(MouseEvent event)throws IOException {
        if(listTimer.isEmpty()){}
        else{
            for (int i = 0 ; i<=listTimer.size()-1;i++){
                listTimer.get(i).getClock().stop();
            }
        }
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Healthy Meals");
        stage.setScene(scene);
        stage.show();
    }                
    @FXML
    private void ReminderBook(MouseEvent event) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        if (event.getButton() == MouseButton.PRIMARY) {
            if(title.getText().equals("")||date.getEditor().getText().equals("")||time.getEditor().getText().equals("")){
                lblmsg.setText("Enter the title ,time and date fileds");
            }
            else if(obalarm.contains(title.getText()+"  "+date.getEditor().getText()+" at "+time.getValue().format(dateTimeFormatter))){
                lblmsg.setText("The remind time is already exists");
            }
            else{
                Session session = HibernateUtil.getSessionFactory().openSession();//add
                List<Timer> TList = null;
                String queryStr = "from Timer";
                Query query = session.createQuery(queryStr);
                TList = query.list();
                session.close();
                boolean isfound=false;
                for(Timer T: TList){  
                    if(T.getUsername().equals(username_database)){
                        if(T.getTitle().equals(title.getText())){
                            lblmsg.setText("The remind name is already exists");
                            isfound = true;
                        }
                    }
                }   
                if (!isfound){
                    String remind =title.getText()+"  "+date.getEditor().getText()+" at "+time.getValue().format(dateTimeFormatter) ;
                    lblmsg.setText("");
                    lvalarm.getSelectionModel().clearSelection();
                    lvtext.getSelectionModel().clearSelection();
                    text = new TextField();
                    text.setMaxWidth(130);
                    text.setAlignment(Pos.CENTER);
                    ////insert Timer list
                    alarm = new Timer(title.getText(),time.getValue(),date.getValue(), text);
                    alarm.setUsername(username_database);
                    session = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = session.beginTransaction();
                    session.save(alarm);
                    tx.commit();
                    session.close();
                    System.out.println("inserted Timer: "+remind);
                    listTimer.add(alarm);
                    text=(timer(alarm));
                    obtext.add(text);
                    obalarm.add(remind);
                    alarm.setUsername(username_database); 
                    title.clear();
                    time.getEditor().clear();
                    date.getEditor().clear();  
                }            
            }        
        }         
    }
    //https://stackoverflow.com/questions/41235093/countdown-timer-that-is-date-and-time-specific
    //https://stackoverflow.com/questions/42383857/javafx-live-time-and-date/42384436
    public TextField timer(Timer alarm){
        long days ;
        long seconds ;
        long minutes;
        long hours  ;               
        Timeline clock =alarm.getClock();
        clock= new Timeline(new KeyFrame(Duration.ZERO, e -> { 
            Calendar thatDay = Calendar.getInstance();
            thatDay.setTime(new Date(0)); /* reset */
            thatDay.set(Calendar.HOUR_OF_DAY,alarm.getTime().getHour());
            thatDay.set(Calendar.MINUTE,alarm.getTime().getMinute());
            thatDay.set(Calendar.DAY_OF_MONTH,alarm.getDate().getDayOfMonth());
            thatDay.set(Calendar.MONTH,Math.abs(alarm.getDate().getMonthValue()-1)); 
            thatDay.set(Calendar.YEAR, alarm.getDate().getYear());
            Calendar today = Calendar.getInstance();
            long diff =  thatDay.getTimeInMillis() - today.getTimeInMillis(); 
            long diffSec = diff / 1000;
            alarm.setDays(diffSec / alarm.getSECONDS_IN_A_DAY());
            long secondsDay = diffSec % alarm.getSECONDS_IN_A_DAY();
            alarm.setSeconds(secondsDay % 60);
            alarm.setMinutes((secondsDay / 60) % 60);
            alarm.setHours((secondsDay / 3600));
            alarm.getText().setText(alarm.getHours() + ":" + alarm.getMinutes()+ ":" + alarm.getSeconds()+" days:"+alarm.getDays());
            alarm.getText().setAlignment(Pos.CENTER);
            if(alarm.getHours()<=0&&alarm.getMinutes()<=0&&alarm.getSeconds()<=0&&alarm.getDays()<=0){
                ////delete Timer list
                int index = obtext.indexOf(alarm.getText());
                listTimer.get(index).getClock().stop();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
                Notification(alarm.getTitle(),alarm.getTime().format(dateTimeFormatter),alarm.getDate().toString());      
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<Timer> TList = null;
                String queryStr = "from Timer";
                Query query = session.createQuery(queryStr);
                TList = query.list();      
                session.close();
                session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx2 = null;
                tx2 = session.beginTransaction();
                for(Timer T: TList){
                    if(T.getUsername().equals(username_database)){
                        if(T.getTitle().equalsIgnoreCase(alarm.getTitle())){
                            session.delete(T);
                        }
                    }
                }
                tx2.commit();
                session.close();
                System.out.println("deleted alarm: "+obalarm.get(index));
                if(index>=0){
                    obtext.remove(index);
                    obalarm.remove(index); 
                    listTimer.remove(index); 
                }
            }
            //System.out.printf("%d days, %d hours, %d minutes and %d seconds\n", alarm.getDays(), alarm.getHours(), alarm.getMinutes(), alarm.getSeconds());//بشيله بعدين
        }),
                new KeyFrame(Duration.seconds(1))
        );
        alarm.setClock(clock);
        alarm.getClock().setCycleCount(Animation.INDEFINITE);
        alarm.getClock().play();
        return alarm.getText();
    } 

    private void Notification(String title,String time ,String date) {
        try {    
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("Popup.fxml"));
            Parent root=loader.load();
            Scene scene=new Scene(root);            
            Stage stage = new Stage();
            stage.setTitle("PopUp");
            stage.setScene(scene);  
            stage.show();
            PopupController p=loader.getController(); 
            p.Alarm();
            p.setPopupTitlemsg(title);
            p.setPopupTimemsg(time);
            p.setPopupDatemsg(date);
        }
        catch(IOException e) {}
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Locale.setDefault(Locale.ENGLISH);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        title.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");        
        ////retrive Timer list
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<Timer> tList = null;
        String queryStr = "from Timer";
        Query query = session1.createQuery(queryStr);
        tList = query.list();
        session1.close();
        for(Timer t: tList){
            if(t.getUsername().equals(username_database)){
            t.setTime(LocalTime.parse(t.gettime(), DateTimeFormatter.ofPattern("hh:mm a")));
            t.setDate(LocalDate.parse(t.getdate()));            
            alarm =new Timer(t.getTitle(),t.getTime(),t.getDate(), t.getText());
            listTimer.add(alarm);
            obalarm.add(t.getTitle()+" "+t.getdate()+" at "+t.gettime());
            text = timer(alarm);
            text.setMaxWidth(130);
            text.setAlignment(Pos.CENTER);            
            obtext.add(text);
            }
        }         
        lvalarm.setCellFactory((new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new XCell();
            }
        }));
        lvtext.setItems(obtext);
        lvalarm.setItems(obalarm);  
        lvalarm.getSelectionModel().selectedItemProperty().addListener(e-> {
                lvalarm.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                int index = lvalarm.getSelectionModel().getSelectedIndex();
                lvtext.getSelectionModel().select(index);
                if(index>=0){
                    String[] item = obalarm.get(index).split(" ");
                    String otitle = item [0];
                    int in = otitle.length();
                    String date_time = item [1];
                    title.setText(otitle);
                    String[] DateTime = obalarm.get(index).split(" at ");
                    date.getEditor().setText(DateTime[0].substring(in));
                    time.getEditor().setText(DateTime[1]); 
                }
            });
         lvtext.getSelectionModel().selectedItemProperty().addListener(e-> {
                lvtext.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                int index = lvtext.getSelectionModel().getSelectedIndex();
                lvalarm.getSelectionModel().select(index);
                if(index>=0){
                    String[] item = obalarm.get(index).split(" ");
                    String otitle = item [0];
                    int in = otitle.length();
                    String date_time = item [1];
                    title.setText(otitle);
                    String[] DateTime = obalarm.get(index).split(" at ");
                    date.getEditor().setText(DateTime[0].substring(in));
                    time.getEditor().setText(DateTime[1]);
                }
         });
    }     
    //https://stackoverflow.com/questions/15661500/javafx-listview-item-with-an-image-button
    class XCell extends ListCell<String> {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Label space = new Label("   ");
        Pane pane = new Pane();
        Button button = new Button("X");
        String lastItem;
        public XCell() {
            super();
            button.setStyle("-fx-background-color: eea1bd; -fx-font: normal bold 15 'Comic Sans MS Bold' ; ");
            button.setTextFill(Color.web("#fff9fe"));
            hbox.getChildren().addAll(space,label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            hbox.setAlignment(Pos.CENTER);
            button.setOnAction(e -> {    
                int index = obalarm.indexOf(lastItem);
                lblmsg.setText("Alarm Time "+obalarm.get(index)+" was Deleted"); 
                Session session = HibernateUtil.getSessionFactory().openSession();//handel the transient entity in delete processing error
                List<Timer> TList = null;
                String queryStr = "from Timer";
                Query query = session.createQuery(queryStr);
                TList = query.list();      
                session.close();               
                ////delete Timer list
                
                session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = null;
                tx = session.beginTransaction();
                for(Timer T: TList){
                    if(T.getUsername().equals(username_database)){
                        if(T.getTitle().equalsIgnoreCase(listTimer.get(index).getTitle())){
                            session.delete(T);
                        }
                    }
                }                
                tx.commit();
                session.close();
                System.out.println("deleted alarm: "+obalarm.get(index));                
                listTimer.get(index).getClock().stop(); 
                obtext.remove(index);
                obalarm.remove(index); 
                listTimer.remove(index);
                title.clear();
                time.getEditor().clear();
                date.getEditor().clear();
                lvalarm.getSelectionModel().clearSelection();
                lvtext.getSelectionModel().clearSelection();
            });        
        }
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                lastItem = null;
                setGraphic(null);
            } else {
                lastItem = item ;
                label.setText(item!=null ? item : "<null>");
                setGraphic(hbox);
            }
        }
    }    
    
}
