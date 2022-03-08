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
public class BreakfastController implements Initializable {
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
    private TextArea textb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   
        remindTimer();
        textb.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        textb.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");        
    }    

    @FXML
    private void rb1(MouseEvent event) {
        textb.setText("Easy French Toast\n"+"\n"+
                "Most of the work can be done by the kids to make this easy French toast! Delicious and perfect for brunch.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 3 eggs\n" +
" ½ cup milk\n" +
" 1 tbsp brown sugar\n" +
" 1 tsp vanilla\n" +
" ½ teaspoon cinnamon\n" +
" 4 slices thick cut bread\n" +
" A knob of butter\n"+"\n"+
                "----------Instructions----------\n"+
"1-In a large bowl crack the eggs.\n" +
"2-Add the milk, cinnamon, sugar and vanilla and whisk until well combined.\n" +
"3-Dip the bread in the mixture and then flip to coat the other side.\n" +
"4-Place your pan over medium heat and add a knob of butter to coat. \n" +
"5-When the butter starts to sizzle, spread it across the pan.\n" +
"6-Add the soaked bread.\n" +
"7-Cook for 4-5 minutes (or until golden), then flip and cook the other side.\n" +
"8-When it is golden, remove from the pan, add your favourite toppings and serve immediately."

                );        
    }
    @FXML
    private void rb2(MouseEvent event) {
        textb.setText("Scrambled Eggs with Veggies and Toast\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1/2 cup broccoli, florets\n" +
" 1 medium bell pepper, orange\n" +
" 1 none cooking spray\n" +
" 8 large egg\n" +
" 1 cup spinach\n" +
" 3/4 cup cheddar cheese, shredded\n" +
"--Toppings--\n" +
" 1/2 cup salsa\n" +
"--Serve With--\n" +
" 4 slice bread, whole wheat\n" +
" 2 cup mango cubes, frozen\n"+"\n"+
                "----------Instructions----------\n"+
"1-Dice broccoli and bell pepper.\n" +
"2-Heat a skillet on medium-high and spray with cooking spray.\n" +
"3-Crack eggs into a bowl and lightly whisk together; pour into hot skillet.\n" +
"4-Cook until eggs begin to set, then add veggies and cheese. Continue heating until eggs are cooked through, stirring frequently to scramble.\n" +
"5-While eggs are cooking, toast bread.\n" +
"6-Top eggs with salsa and serve with toast and frozen mango on the side."

                );        
    }
    @FXML
    private void rb3(MouseEvent event) {
        textb.setText("Healthy Apple Muffins\n"+"\n"+
                "Made with whole wheat flour, coconut oil, applesauce and maple syrup these Healthy Apple Muffins will be your new favorite apple recipe.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 2 cup flour, whole wheat\n" +
" 2 teaspoon baking soda\n" +
" 1 teaspoon baking powder\n" +
" 2 1/2 teaspoon cinnamon\n" +
" 1 teaspoon salt\n" +
" 3 large egg\n" +
" 2/3 cup maple syrup, pure\n" +
" 1/3 cup coconut oil\n" +
" 1/3 cup applesauce, unsweetened\n" +
" 2 tsp vanilla extract\n" +
" 2 cup, grated apple\n" +
" 1/2 cup walnuts, chopped\n"+"\n"+
                "----------Instructions----------\n"+
"1-Preheat oven to 425 degrees and line a muffin tin with cupcake liners or grease the wells.\n" +
"2-In a bowl, combine flour, baking soda, baking powder, cinnamon and salt.\n" +
"3-In a separate bowl, whisk together eggs, maple syrup, melted coconut oil, apple sauce and vanilla extract.\n" +
"4-Pour the dry ingredients into the wet and slowly fold together.  Before it’s all combined, add grated apples and walnuts (or you can use pecans). Stir just until combined.\n" +
"5-Fill muffin tins all the way to the top!  Bake at 425 degrees for 5 minutes and then decrease the temperature to 350 and bake for 12-18 minutes.  Bake until an inserted toothpick comes out clean.\n" +
"6-Let cool and serve."

                );        
    }
    @FXML
    private void rb4(MouseEvent event) {
        textb.setText("Strawberry Pancakes\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1 1/2 cup flour, whole wheat\n" +
" 1 teaspoon baking powder\n" +
" 1/2 teaspoon salt\n" +
" 1 cup milk\n" +
" 2 large egg\n" +
" 2 tablespoon butter, unsalted\n" +
" 2 teaspoon vanilla extract\n" +
" 1 tablespoon honey\n" +
" 1 1/2 cup strawberries\n" +
"--Toppings--\n" +
" 1/4 cup maple syrup, pure\n" +
" 2 cups strawberries, chopped for topping\n"+"\n"+
                "----------Instructions----------\n"+
"1-In a large mixing bowl, whisk together flour, baking powder, and salt.\n" +
"2-In a separate bowl, whisk together milk, eggs, melted butter, vanilla, and honey.\n" +
"3-Gradually add dry ingredients to the wet, mixing after each addition until just combined.\n" +
"4-Chop strawberries and fold into batter.\n" +
"5-Spray a griddle with cooking spray and heat over medium.\n" +
"6-Pour batter by 1/4 cup fulls onto hot skillet. Cook until bubbly, then flip and cook an additional minute until cooked through and golden.\n" +
"7-Serve drizzled with maple syrup."

                );        
    }
    @FXML
    private void rb5(MouseEvent event) {
        textb.setText("Spring Veggie Egg Cups\n"+"\n"+
                "cheesy egg cups packed with fresh spring vegetables! Make these ahead for a quick breakfast option during the week.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 4 large egg\n" +
" 1 cup, chopped onion\n" +
" 10 spear asparagus\n" +
" 3 cup peas and carrots, frozen\n" +
" 1 cup cottage cheese\n" +
" 1 cup mozzarella cheese\n" +
" 1 cup Parmesan cheese, grated\n" +
" 1 dash salt\n" +
" 2 teaspoon butter, unsalted\n"+"\n"+
                "----------Instructions----------\n"+
"1-Preheat oven to 350 F and fill a standard-sized muffin tin with silicone liners. (You can also try brushing a metal muffin tin with butter, but they might not pop out as flawlessly as they do from silicone.)\n" +
"2-In a pan over medium heat, melt the butter and add the chopped onions. Saute until soft and beginning to brown, about 5 minutes.\n" +
"3-Meanwhile, chop the asparagus spears into bite-sized pieces.\n" +
"4-Add the asparagus spears to the pan and saute briefly until just beginning to turn bright green.\n" +
"5-Stir in the frozen peas and carrots until they’re just warmed through, then remove from heat and salt to taste.\n" +
"6-In a large mixing bowl, fork-whisk eggs, cottage cheese, Mozzarella, and Parmesan."+
"7-Fold in the vegetable mixture.\n" +
"8-Scoop the egg and veggie mixture into 12 silicone muffin cups.\n" +
"9-Bake 15-20 minutes until egg is set. Let cool slightly before serving."

                );        
    }
    @FXML
    private void rb6(MouseEvent event) {
        textb.setText("Kids’ Breakfast Panini\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1 none cooking spray\n" +
" 4 large egg\n" +
" 1 medium mango\n" +
" 8 slice bread, french\n" +
" 4 slice cheddar cheese\n" +
" 1/4 cup salsa\n" +
" 1 tablespoon olive oil\n"+"\n"+
                "----------Instructions----------\n"+
"1-Spray a large skillet with cooking spray and heat over medium.\n" +
"2-Crack eggs into a bowl and whisk together. Pour into hot skillet and cook until set, stirring frequently to scramble.\n" +
"3-Peel mango and slice thinly. Preheat panini/sandwich press.\n" +
"4-Top each of 4 bread slices with 1/4 of the eggs, a slice of cheese, some mango slices, 1 tablespoon of salsa, and another piece of bread.\n" +
"5-Brush oil on the outsides of the bread (or spray with additional cooking spray) and place on a hot panini press. Cook until golden brown and cheese has melted.\n" +
"6-Cool slightly, cutting each sandwich into quarters before serving."

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
