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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SnackController implements Initializable {

    @FXML
    private TextArea texts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        remindTimer();
        texts.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        texts.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");        
         
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
    private void rs1(MouseEvent event) {
        texts.setText("Healthy Cheese Balls\n"+"\n"+
                "We knew there was a way to make healthy cheese balls for kids by adding spinach, and they turned out amazing!\n"+"\n"+
                "----------Ingredients----------\n"+
                " 3 medium russet potato\n" +
" 1/2 cup spinach\n" +
" 1 ounce cheddar cheese\n" +
" 1/4 cup cottage cheese\n" +
" 1 large egg\n" +
" 1 cup bread crumbs, plain\n" +
" 1/2 teaspoon onion powder\n" +
" 1/2 teaspoon salt\n" +
" 1/8 teaspoon black pepper, ground\n" +
" 2 tablespoon oil, avocado\n"+"\n"+
                "----------Instructions----------\n"+
"1-Peel and cube potatoes. Add to a saucepan with enough water to cover. Boil for 10-15 minutes or until softened. Drain and allow to cool completely.\n" +
"2-Chop spinach and mix together in a large bowl with the potato. Mash together.\n" +
"3-Grate cheddar into the potato mixture. Add cottage cheese and lightly whisked egg. Mix until thoroughly combined.\n" +
"4-In a shallow dish, mix together bread crumbs, onion powder, salt, and pepper.\n" +
"5-Scoop potato mixture by the tablespoon and shape into rounds the size of a golf ball. Roll into bread crumbs and set aside.\n" +
"6-Heat oil in a large skillet over medium-high heat. Gently add each cheese ball without overlapping. Cook until golden on all sides.\n" +
"7-Place cheese balls onto a plate lined with paper towels.\n" +
"8-Cool slightly and serve."

                );
    }
    @FXML
    private void rs2(MouseEvent event) {
        texts.setText("Veggie Dip\n"+"\n"+
                "Here’s a simple, solidly tasty Veggie Dip made from Greek yogurt and flavored with handy dried herbs and spices. Serve it to kids who love to dip!\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1 cup Greek yogurt, plain\n" +
" 1/2 teaspoon garlic powder\n" +
" 1/2 teaspoon onion powder\n" +
" 1/2 teaspoon parsley, dried\n" +
" 1/2 teaspoon chives, dried\n" +
" 1/4 teaspoon dill weed, dried\n" +
" 1 teaspoon lemon juice\n" +
" 1/8 teaspoon black pepper, ground\n" +
" 1/2 teaspoon salt\n" +
" 1/4 cup milk\n" +
"--Serve With--\n" +
" 1 medium bell pepper, orange\n" +
" 1 medium bell pepper, yellow\n" +
" 1 medium cucumber\n" +
" 1 cup cherry tomatoes\n"+"\n"+
                "----------Instructions----------\n"+
"1-Place all ingredients except the milk into a large mixing bowl. Mix until smooth and blended together. To reach desired consistency, add 1-2 tablespoons of milk at a time, thoroughly mixing after each addition of milk.\n" +
"2-Slice peppers and cucumbers. Serve veggies with dip."

                );        
    }    
    @FXML
    private void rs3(MouseEvent event) {
        texts.setText("FroYo Bites\n"+"\n"+
                "Fruity FroYo Bites deliver the goodness of yogurt and fresh fruit in a fun way, without added sugars.\n"+"\n"+
                "----------Ingredients----------\n"+
                "--Pink--\n" +
" 1 cup yogurt, plain\n" +
" 1 cup strawberries\n" +
"--Purple--\n" +
" 1 cup yogurt, plain\n" +
" 1 cup blackberries\n"+"\n"+
                "----------Instructions----------\n"+
"1-For pink, blend plain yogurt and strawberries together in a food processor or blender.\n" +
"2-For purple, blend plain yogurt and blackberries or blueberries together in a food processor or blender.\n" +
"3-Using a piping bag or small spoon, scoop yogurt into a mold or ice cube tray. Freeze until ready to eat.\n" +
"4-Makes 10-12 ‘cubes’ of each flavor."

                );        
    }
    @FXML
    private void rs4(MouseEvent event) {
        texts.setText("Orange Julius Recipe\n"+"\n"+
                "Serve up a fresh glass of vitamin C, protein, and real fruit with this healthy Orange Julius recipe made from simple whole food ingredients.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 3/4 cup orange juice\n" +
" 1 container (8 oz) Greek Yogurt\n" +
" 2 teaspoon vanilla extract\n" +
" 2 medium banana, frozen\n" +
" 2 tablespoon honey\n" +
" 1 tbsp orange zest\n" +
" 1 large orange peeled\n"+"\n"+
                "----------Instructions----------\n"+
"1-Using a high powered blender, add orange juice, yogurt, vanilla, chopped banana, zest of one orange, whole peeled orange and honey. Blend together well. If a thicker consistency is desired, add ice."

                );        
    }
    @FXML
    private void rs5(MouseEvent event) {
        texts.setText("Pink Lamingtons\n"+"\n"+
                "Deliciously light sponge cake coated in a sweet sticky jelly coating and covered in coconut sprinkles. Kid friendly and freezer friendly.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 4 eggs\n" +
" ⅔ cup sugar\n" +
" 1.5 teaspoons vanilla extract\n" +
" 1 cup self raising flour\n" +
" 1 pkt jelly crystals\n" +
" 1 cup boiling water\n" +
" 1 cup cold water\n" +
" 2 cups desiccated coconut\n"+"\n"+
                "----------Instructions----------\n"+
"1-Place the eggs into your mixer. Beat until light fluffy and doubled in size.\n" +
"2-Add the sugar, ¼ cup at a time, beating after each addition.\n" +
"3-Add the vanilla and beat in.\n" +
"4-Add the flour and fold through.\n" +
"5-Pour into 20cm square lined (or silicone) cake tins.\n" +
"6-Bake at 160º celsius fanforced (180 conventional)320F/355F for 18 minutes.\n" +
"7-Remove to wire racks to cool completely. Cut into fingers.\n" +
"8-Add the jelly crystals to a large jug/bowl.\n" +
"9-Add one cup of boiling water and whisk until all jelly crystals are dissolved.\n" +
"10-Add one cup of cold water. Refrigerate for 1.5 hours or until it resembles the consistency of egg whites.\n" +
"11-Whisk the jelly slightly.\n" +
"12-Dip the cake fingers into the jelly, coating completely.\n" +
"13-Coat in the coconut, then refrigerate until serving.."

                );        
    }
    @FXML
    private void rs6(MouseEvent event) {
        texts.setText("Veggie Snack Nuggets\n"+"\n"+
                "Just like chicken nuggets, veggie nuggets are the perfect finger food for little hands. We love the Veggie Nuggets Recipe, because it’s just one extra way to get those veggies in.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1 medium onion\n" +
" 2 medium russet potato\n" +
" 3 medium carrot\n" +
" 2 clove garlic\n" +
" 2 1/2 tablespoon olive oil\n" +
" 1/2 cup green peas, frozen\n" +
" 1/4 teaspoon salt\n" +
" 1/4 teaspoon black pepper, ground\n" +
" 1 medium lemon\n" +
" 3/4 cup bread crumbs, plain\n"+"\n"+
                "----------Instructions----------\n"+
"1-Dice onion, shred potatoes and carrots, and mince garlic.\n" +
"2-Heat 2 tablespoons olive oil in a medium skillet, then add diced onion; cook for 2 minutes or until softened.\n" +
"3-Add potatoes and carrots; continue to cook for 5 minutes, stirring frequently.\n" +
"4-Mix in garlic, peas, salt, and pepper; continue to cook for 3 minutes more.\n" +
"5-Remove from heat, stir in juice from the lemon and 1/4 cup breadcrumbs; set aside until mixture is cool enough to handle.\n" +
"6-Shape veggie mixture into 15 to 20 balls; refrigerate for at least 30 minutes.\n" +
"7-Place remaining breadcrumbs in a shallow dish. Heat remaining olive oil in a skillet over medium-high.\n" +
"8-Roll the balls into the breadcrumbs until coated on all sides.\n" +
"9-Add 4 to 5 nuggets at a time to the hot skillet and cook for 2-3 minutes on each side until nicely browned. Drain on paper towels and repeat the process with the remaining veggie balls until all have been cooked, adding more oil as necessary."

                );        
    }
    public void Back(MouseEvent event)throws IOException {
        stop();
        Parent root = FXMLLoader.load(getClass().getResource("Recipes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Recipes");
        stage.setScene(scene);
        stage.show(); 
    }      
}
