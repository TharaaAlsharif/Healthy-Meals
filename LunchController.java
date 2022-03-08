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
public class LunchController implements Initializable {
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
    private TextArea textl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
        remindTimer();
        textl.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        textl.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");
    }    

    @FXML
    private void rl1(MouseEvent event) {
        textl.setText("English Muffin Pizzas\n"+"\n"+
                "----------Ingredients----------\n"+
                " 4 regular English muffin, wheat\n" +
" 2 cup spaghetti or marinara sauce\n" +
" 1 medium bell pepper, green\n" +
" 1/2 cup, pieces or slices mushrooms, white\n" +
" 16 jumbo black olives, canned\n" +
" 4 ounce mozzarella cheese\n" +
"--Serve With--\n" +
" 2 cup grapes\n"+"\n"+
                "----------Instructions----------\n"+
"1-Preheat oven to 375° F.\n" +
"2-Place the English muffin halves, sliced side up, onto a baking sheet. Spoon some of the pizza sauce onto each one.\n" +
"3-Chop bell pepper, mushrooms, and olives. Top each muffin half with mozzarella cheese and add other toppings as desired.\n" +
"4-Bake for 10 minutes or until the cheese has melted and the edges are browned.\n" +
"5-Serve with grapes on the side."

                );        
    }
    @FXML
    private void rl2(MouseEvent event) {
        textl.setText("Slow Cooker Chicken Vegetable Stew\n"+"\n"+
                "Slow Cooker Vegetable Soup is hearty, delicious and kid-friendly.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1 medium onion\n" +
" 1 medium carrot\n" +
" 1 stalk celery\n" +
" 1 medium sweet potato\n" +
" 1 medium russet potato\n" +
" 2 medium boneless, skinless chicken breasts\n" +
" 4 cup, chopped kale\n" +
" 4 clove garlic\n" +
" 1 teaspoon Italian Seasoning\n" +
" 1 can diced tomatoes, canned\n" +
" 2 cup pumpkin, canned\n" +
" 4 cup chicken broth, low-sodium\n" +
" 1/2 teaspoon sea salt\n" +
" 1/8 teaspoon black pepper, ground\n"+"\n"+
                "----------Instructions----------\n"+
"1-Chop onion, carrot, and celery. Peel and dice potatoes. Cut chicken into bite-sized cubes. Add to the crockpot along with the remaining ingredients; stir well.\n" +
"2-Cook on low for 8 hours."

                );        
    } 
    @FXML
    private void rl3(MouseEvent event) {
        textl.setText("Roasted Vegetable Pasta Salad\n"+"\n"+
                "An easy and healthy pasta salad recipe packed full of delicious summer vegetables.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1 red onion\n" +
" 1 red bell pepper\n" +
" 1 yellow bell pepper\n" +
" 1 zucchini\n" +
" 7 oz asparagus\n" +
" 7 oz baby broccoli\n" +
" 5 oz cherry tomatoes\n" +
" 2 tbsp olive oil\n" +
" 2 tsp dried oregano\n" +
" 14 oz dried pasta\n" +
" 1 cup prepared Italian salad dressing\n"+"\n"+
                "----------Instructions----------\n"+
"1-Chop the vegetables and place them in a large bowl with the olive oil and oregano. Mix well until all the vegetables are coated.\n" +
"2-Divide the vegetables between two baking trays or dishes and roast in a 400f oven for 15 minutes, turning once.\n" +
"3-Meanwhile cook the pasta according to package instructions. Drain it under cold water and allow it to cool.\n" +
"4-Let veggies cool for 20 minutes on the pan, then toss in a large bowl with pasta and prepared dressing.\n" +
"5-Serve at room temperature or store in an airtight container in the fridge for up to 2 days."

                );        
    }
    @FXML
    private void rl4(MouseEvent event) {
        textl.setText("Broccoli Apple Salad\n"+"\n"+
                "Sweet poppy seed dressing and convenient broccoli slaw mix make this healthy .\n"+"\n"+
                "----------Ingredients----------\n"+
                " 2 medium apple\n" +
" 4 cup shredded veggies, bagged (such as broccoli slaw)\n" +
" 1/4 cup poppy seed dressing, light\n" +
" 1/2 cup cranberries, dried\n" +
" 1/4 cup almonds, sliced\n"+"\n"+
                "----------Instructions----------\n"+
"1-Dice apples and toss with broccoli slaw.  Mix in a bowl with dressing.\n" +
"2-For homemade poppyseed dressing, try this recipe. Otherwise, we love the Brianna’s brand.\n" +
"3-Add in the remaining ingredients; serve or store covered, in the refrigerator."

                );        
    }
    @FXML
    private void rl5(MouseEvent event) {
        textl.setText("Muffin Tin Pot Pie\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1 batch of crescent dough\n" +
" 1 1/2 cups of cream of chicken soup\n" +
" 1 cup of mixed vegetables\n" +
" 1 cup of cubed chicken\n" +
" salt and pepper to taste\n"+"\n"+
                "----------Instructions----------\n"+
"1-Preheat the oven to 375 degrees.  Lay your crescent dough flat then use a 3-inch cookie cutter to make round shapes.  Lay the round dough shapes in the muffin pan and press along the bottom & sides\n" +
"2-Mix cream of chicken soup,  with 1 cup of cubed chicken and 1 cup of mixed vegetables in a bowl.   Add salt and pepper to taste.\n" +
"3-Spoon the filling mix into the cups with about 1-2 tablespoons per cup.\n" +
"4-Bake for 15 minutes or until golden brown.  Let cool on cookie sheet for 3-5 minutes."

                );        
    }
    @FXML
    private void rl6(MouseEvent event) {
        textl.setText("Pita Pizzas\n"+"\n"+
                "----------Ingredients----------\n"+
                " 6 large pita, whole wheat\n" +
" 1 cup cheddar cheese, shredded\n" +
" 1/2 medium zucchini\n" +
" 1/2 cup corn, canned\n" +
" 3/4 cup pizza sauce\n" +
" 1/2 medium bell pepper, yellow\n" +
" 6 medium mushrooms, white\n" +
" 1/2 teaspoon oregano, dried\n" +
" 1/2 teaspoon thyme, dried\n" +
"--Meat--\n" +
" 2 ounces beef, ground, 90% lean\n" +
" 1 medium onion\n" +
" 15 ounce tomato sauce\n" +
" 1/2 cup olive oil\n" +
" 2 medium carrot\n" +
" 1 teaspoon oregano, dried\n" +
" 1 teaspoon paprika\n" +
" 1 teaspoon thyme, dried\n" +
" 1 teaspoon salt\n" +
" 1 teaspoon basil, dried\n"+"\n"+
                "----------Instructions----------\n"+
"1-Spread 2 tbsp of pizza tomato sauce on each pita bread\n" +
"2-Top it with the desired produce\n" +
"3-Add the shredded cheese last\n" +
"4-Place the pita breads with the topping in a preheated oven 392 F (200C) until the cheese melts well.\n" +
"5-To make the meat sauce: Add half the oil to a hot saucepan.\n" +
"6-Saute the ground meat and separate it with your spatula\n" +
"7-When it turns brownish add the onion and saute that as well.\n" +
"8-Add the herbs and saute for another 5 minutes.\n" +
"9-Last, add the tomato sauce and leave everything simmering for about an hour stirring occasionally.\n" +
"10-Add the rest of the olive oil when the sauce starts to dry a little and turn."

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
