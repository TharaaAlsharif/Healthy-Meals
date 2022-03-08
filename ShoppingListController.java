/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import static healthymeals.loginController.username_database;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class ShoppingListController implements Initializable {
    Session session = HibernateUtil.getSessionFactory().openSession();

    @FXML
    private TextField tfItem;

    @FXML
    private ListView<String> lvShoppingList;
    
    @FXML
    private Label lblMsgItem;
    
    @FXML
    private ListView<CheckBox> lvCheckBoxes;
    
    ObservableList<String> obShoppingList  = FXCollections.observableArrayList();
    
    ObservableList<CheckBox> obCheckBoxes  = FXCollections.observableArrayList();
    
    String check;
    Item item ;
    CheckBox checkbox;

    @FXML
    void imgAddHandel(MouseEvent event) {
        if(tfItem.getText().isEmpty())
            lblMsgItem.setText("Enter an item");
        else{
            session = HibernateUtil.getSessionFactory().openSession();
            List<Item> iList = null;
            String queryStr = "from Item";
            Query query = session.createQuery(queryStr);
            iList = query.list();
            session.close();
            boolean isfound=false;
            for(Item i: iList){
                if(i.getUsername().equals(username_database)){
                    if(i.getItem().equalsIgnoreCase(tfItem.getText())){
                    lblMsgItem.setText("The item already entered in the list");
                    isfound = true;
                    }
                }
            }
            if (!isfound){
                lblMsgItem.setText("");
                checkbox = new CheckBox();
                checkbox.setStyle( "-fx-padding: 5px;");
                obShoppingList.add(tfItem.getText());
                obCheckBoxes.add(checkbox);
                item = new Item();
                item.setItem(tfItem.getText()); 
                item.setUsername(username_database);
                try{
                     session = HibernateUtil.getSessionFactory().openSession();
                     Transaction tx = session.beginTransaction();
                     session.save(item);
                     tx.commit();
                     session.close();
                     System.out.println("inserted item: "+item.getItem());
                }
                catch(Exception e){ 
                    e.getMessage();
                }  
                tfItem.clear();
            }
        }
    } 
     
    @FXML
    void tfItemHandel(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if(tfItem.getText().isEmpty())
                lblMsgItem.setText("Enter an item");
            else{
                session = HibernateUtil.getSessionFactory().openSession();
                List<Item> iList = null;
                String queryStr = "from Item";
                Query query = session.createQuery(queryStr);
                iList = query.list();
                session.close();
                boolean isfound=false;
                for(Item i: iList){
                    if(i.getUsername().equals(username_database)){
                        if(i.getItem().equalsIgnoreCase(tfItem.getText())){
                        lblMsgItem.setText("The item already entered in the list");
                        isfound = true;
                        }
                    }
                }
                if(!isfound){
                    lblMsgItem.setText("");
                    checkbox = new CheckBox();
                    checkbox.setStyle( "-fx-padding: 5px;");
                    obShoppingList.add(tfItem.getText());
                    obCheckBoxes.add(checkbox);
                    item = new Item();
                    item.setItem(tfItem.getText()); 
                    item.setUsername(username_database);
                    try{
                         session = HibernateUtil.getSessionFactory().openSession();
                         Transaction tx = session.beginTransaction();
                         session.save(item);
                         tx.commit();
                         session.close();
                         System.out.println("inserted item: "+item.getItem());
                    }
                    catch(Exception e){ 
                        e.getMessage();
                    }  
                }
                tfItem.clear();
            }
        }
    }
    
    @FXML
    void btClearHandel(ActionEvent event) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Item> iList = null;
        String queryStr = "from Item";
        Query query = session.createQuery(queryStr);
        iList = query.list();      
        session.close();
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = null;
        tx2 = session.beginTransaction();
        
        for(Item i: iList){
            if(i.getUsername().equals(username_database)){
            session.delete(i);
            }
        }
        tx2.commit();
        session.close();
        obShoppingList.clear();
        obCheckBoxes.clear();
        System.out.println("Clear Done");   
    }

    //Reference For the code: https://stackoverflow.com/questions/15661500/javafx-listview-item-with-an-image-button  To add Buttons inside the listView
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
            hbox.setAlignment(Pos.BOTTOM_LEFT);
            try{
                button.setOnAction(e -> {
                lblMsgItem.setText("");

                    session = HibernateUtil.getSessionFactory().openSession();
                    List<Item> iList = null;
                    String queryStr = "from Item";
                    Query query = session.createQuery(queryStr);
                    iList = query.list();      
                    session.close();
                    session = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx2 = null;
                    tx2 = session.beginTransaction();
                    for(Item i: iList){
                        if(i.getUsername().equals(username_database)){
                        if(i.getItem().equalsIgnoreCase(lastItem))
                            session.delete(i);
                        }
                    }
                    tx2.commit();
                    System.out.println("deleted item: "+lastItem);

                    int indx = obShoppingList.indexOf(lastItem);
                    obShoppingList.remove(indx);
                    obCheckBoxes.remove(indx);

                    setStyle("-fx-control-inner-background: derive(-fx-base,80%) ");

                    lvShoppingList.getSelectionModel().clearSelection();

                });
            }
            catch(Exception e){ 
                e.getMessage();
            }
            
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
    
    @FXML
    void imgSaveHandel(MouseEvent event) {
        lvCheckBoxes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvShoppingList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        String str;
            for (int i = 0; i < obCheckBoxes.size() ; i++) {
                if(obCheckBoxes.get(i).isSelected()){
                    lvCheckBoxes.getSelectionModel().select(i);
                    lvShoppingList.getSelectionModel().select(i);
                    str = lvShoppingList.getSelectionModel().getSelectedItem();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    List<Item> list = null;
                    String queryStr = "from Item";
                    Query query = session.createQuery(queryStr);
                    list = query.list();
                    session.close();
                    for(Item item: list){
                        if(item.getUsername().equals(username_database)){
                        if(item.getItem().equalsIgnoreCase(str)){
                            item.setstatus("checked");
                            session = HibernateUtil.getSessionFactory().openSession();
                            Transaction tx = session.beginTransaction();
                            session.update(item);
                            tx.commit();
                            session.close();
                            System.out.println("update ");
                        }
                        }
                    } 
                }
                else if(! obCheckBoxes.get(i).isSelected()){
                    lvCheckBoxes.getSelectionModel().select(i);
                    lvShoppingList.getSelectionModel().select(i);
                    str = lvShoppingList.getSelectionModel().getSelectedItem();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    List<Item> list = null;
                    String queryStr = "from Item";
                    Query query = session.createQuery(queryStr);
                    list = query.list();
                    session.close();
                    for(Item item: list){
                        if(item.getUsername().equals(username_database)){
                        if(item.getItem().equalsIgnoreCase(str)){
                            item.setstatus("unchecked");
                            session = HibernateUtil.getSessionFactory().openSession();
                            Transaction tx = session.beginTransaction();
                            session.update(item);
                            tx.commit();
                            session.close();
                            System.out.println("Save changes.");
                        }
                        }
                    }        
                }
            }

    }
        @FXML
    public void Back(MouseEvent e)throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Healthy Meals");
        stage.setScene(scene);
        stage.show();
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remindTimer();
        tfItem.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 18));
        tfItem.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");

        lvShoppingList.setItems(obShoppingList);
        lvCheckBoxes.setItems(obCheckBoxes);
        
        lvShoppingList.getSelectionModel().selectedItemProperty().addListener(e-> {
            int idx = lvShoppingList.getSelectionModel().getSelectedIndex();
            if(idx>=0){
            tfItem.setText(obShoppingList.get(idx));
            lvCheckBoxes.getSelectionModel().select(idx);}
        });
        lvCheckBoxes.getSelectionModel().selectedItemProperty().addListener(e-> {
            int idx = lvCheckBoxes.getSelectionModel().getSelectedIndex();
            if(idx>=0){
            tfItem.setText(obShoppingList.get(idx));
            lvShoppingList.getSelectionModel().select(idx);
            }
        });
        lvShoppingList.setCellFactory((new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new XCell();
            }
        }));
        
        // retrive the items from the database
        session = HibernateUtil.getSessionFactory().openSession();
        List<Item> itemList = null;
        String queryStr = "from Item";
        Query query = session.createQuery(queryStr);
        itemList = query.list();
        session.close();
        System.out.println("items list size: "+itemList.size());
        for(Item i: itemList){
            if(i.getUsername().equals(username_database)){
            obShoppingList.add(i.getItem());
            checkbox = new CheckBox();
            checkbox.setStyle( "-fx-padding: 5px;");
            obCheckBoxes.add(checkbox);
            }
        }
        
        // retrive the status from the database
        session = HibernateUtil.getSessionFactory().openSession();
        List<Item> iList = null;
        String queryStr2 = "from Item";
        Query query2 = session.createQuery(queryStr2);
        iList = query2.list();
        session.close();
        int j=0;
        for(Item i: iList){
            if(i.getUsername().equals(username_database)){
            if(i.getstatus().equals("checked"))
                obCheckBoxes.get(j).setSelected(true);
            else
                 obCheckBoxes.get(j).setSelected(false);
            j++;
            }
        }  
    }   
    
}