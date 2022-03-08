/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author 96655
 */
public class BMIController implements Initializable {
    
    @FXML
    private TextField tfHeight;

    @FXML
    private TextField tfWeight;

    @FXML
    private TextField tfBMI;

    @FXML
    private Label lblMsg;

    @FXML
    private Button btCalculate;

    @FXML
    private RadioButton rbMale;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton rbFemale;
    
    @FXML
    private Pane pane;
    
    @FXML
    private ImageView imageView;
    
    @FXML
    private Label lblCaption;
    
    @FXML
    private Label lblPart1;

    @FXML
    private Label lblPart2; 
    @FXML
    private Label lblBMI;

    @FXML
    private Label lblAge;
    
    @FXML
    private ComboBox<String> cboAge = new ComboBox();
    
    ObservableList<String> obAge  = FXCollections.observableArrayList("2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
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
    public void Back(MouseEvent e)throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setTitle("Healthy Meals");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void Calculate(ActionEvent event) throws URISyntaxException,IOException {
        if(tfHeight.getText().isEmpty())
           lblMsg.setText("Enter the Height");
        else if(tfWeight.getText().isEmpty())
           lblMsg.setText("Enter the Weight");
        else if(cboAge.getSelectionModel().isEmpty())
           lblMsg.setText("Enter the Age");
        else if (!rbMale.isSelected() & !rbFemale.isSelected())
            lblMsg.setText("Select The gender");
        else {
            lblMsg.setText("");
            double weight = Double.parseDouble(tfWeight.getText());
            double height = Double.parseDouble(tfHeight.getText());
            double BMI = weight / (height * height)*10000;
            tfBMI.setText(String.format("%.2f",BMI));
            if(rbMale.isSelected()){
                lblCaption.setText("*Zoom in/out the picture for clarity.");
                
                pane.getChildren().clear();
                paneImg(IMAGE_URL_BOYS);
                
                lblPart1.setText("Look for the corresponding BMI: ");
                lblPart2.setText("for Age: ");
                lblBMI.textProperty().bind(tfBMI.textProperty());
                //lblAge.setText(cboAge.getValue());
                lblAge.textProperty().bind(cboAge.valueProperty());
            }
            else if(rbFemale.isSelected()){
                lblCaption.setText("*Zoom in/out the picture for clarity.");
                
                pane.getChildren().clear();
                paneImg(IMAGE_URL_GIRLS);
                
                lblPart1.setText("Look for the corresponding BMI: ");
                lblPart2.setText("for Age: ");
                lblBMI.textProperty().bind(tfBMI.textProperty());
                lblAge.textProperty().bind(cboAge.valueProperty());
            }
            
    }
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfHeight.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        tfHeight.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");         
        tfWeight.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        tfWeight.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");   
        tfBMI.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        tfBMI.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");           
        rbMale.setToggleGroup(gender);
        rbFemale.setToggleGroup(gender);
        cboAge.setItems(obAge); 
        remindTimer();
        
    }
    
    //Refrence for the code: https://gist.github.com/james-d/ce5ec1fd44ce6c64e81a to Zoom in/out the picture
    
    private static final String IMAGE_URL_BOYS ="imgs/boysChart.jpg";
    private static final String IMAGE_URL_GIRLS ="imgs/girlsChart.jpg";
    private static final int MIN_PIXELS = 10;
    
    private void paneImg(String img) throws URISyntaxException {
        Image image = new Image(getClass().getResource(img).toURI().toString());
        double width = image.getWidth();
        double height = image.getHeight();
        imageView = new ImageView(image);
        reset(imageView, width , height );

        ObjectProperty<Point2D> mouseDown = new SimpleObjectProperty<>();

        imageView.setOnMousePressed(e -> {
            Point2D mousePress = imageViewToImage(imageView, new Point2D(e.getX(), e.getY()));
            mouseDown.set(mousePress);
        });

        imageView.setOnMouseDragged(e -> {
            Point2D dragPoint = imageViewToImage(imageView, new Point2D(e.getX(), e.getY()));
            shift(imageView, dragPoint.subtract(mouseDown.get()));
            mouseDown.set(imageViewToImage(imageView, new Point2D(e.getX(), e.getY())));
        });

        imageView.setOnScroll(e -> {
            double delta = e.getDeltaY();
            Rectangle2D viewport = imageView.getViewport();

            double scale = clamp(Math.pow(1.01, delta),

                // don't scale so we're zoomed in to fewer than MIN_PIXELS in any direction:
                Math.min(MIN_PIXELS / viewport.getWidth(), MIN_PIXELS / viewport.getHeight()),

                // don't scale so that we're bigger than image dimensions:
                Math.max(width / viewport.getWidth(), height / viewport.getHeight())

            );

            Point2D mouse = imageViewToImage(imageView, new Point2D(e.getX(), e.getY()));

            double newWidth = viewport.getWidth() * scale;
            double newHeight = viewport.getHeight() * scale;

            // To keep the visual point under the mouse from moving, we need
            // (x - newViewportMinX) / (x - currentViewportMinX) = scale
            // where x is the mouse X coordinate in the image

            // solving this for newViewportMinX gives

            // newViewportMinX = x - (x - currentViewportMinX) * scale 

            // we then clamp this value so the image never scrolls out
            // of the imageview:

            double newMinX = clamp(mouse.getX() - (mouse.getX() - viewport.getMinX()) * scale, 
                    0, width - newWidth);
            double newMinY = clamp(mouse.getY() - (mouse.getY() - viewport.getMinY()) * scale, 
                    0, height - newHeight);

            imageView.setViewport(new Rectangle2D(newMinX, newMinY, newWidth, newHeight));
        });

            imageView.setOnMouseClicked(e -> {
                if (e.getClickCount() == 2) {
                reset(imageView, width, height);
            }
        });

        pane.getChildren().add(imageView);
        
        imageView.fitWidthProperty().bind(pane.widthProperty());
        imageView.fitHeightProperty().bind(pane.heightProperty());

    }
    
    // reset to the top left:
    private void reset(ImageView imageView, double width, double height) {
        imageView.setViewport(new Rectangle2D(0, 0, width, height));
    }

    // shift the viewport of the imageView by the specified delta, clamping so
    // the viewport does not move off the actual image:
    private void shift(ImageView imageView, Point2D delta) {
        Rectangle2D viewport = imageView.getViewport();

        double width = imageView.getImage().getWidth() ;
        double height = imageView.getImage().getHeight() ;

        double maxX = width - viewport.getWidth();
        double maxY = height - viewport.getHeight();
        
        double minX = clamp(viewport.getMinX() - delta.getX(), 0, maxX);
        double minY = clamp(viewport.getMinY() - delta.getY(), 0, maxY);

        imageView.setViewport(new Rectangle2D(minX, minY, viewport.getWidth(), viewport.getHeight()));
    }

    private double clamp(double value, double min, double max) {

        if (value < min)
            return min;
        if (value > max)
            return max;
        return value;
    }

    // convert mouse coordinates in the imageView to coordinates in the actual image:
    private Point2D imageViewToImage(ImageView imageView, Point2D imageViewCoordinates) {
        double xProportion = imageViewCoordinates.getX() / imageView.getBoundsInLocal().getWidth();
        double yProportion = imageViewCoordinates.getY() / imageView.getBoundsInLocal().getHeight();

        Rectangle2D viewport = imageView.getViewport();
        return new Point2D(
                viewport.getMinX() + xProportion * viewport.getWidth(), 
                viewport.getMinY() + yProportion * viewport.getHeight());
    }
    
}
