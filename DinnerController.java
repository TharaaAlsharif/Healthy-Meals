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
public class DinnerController implements Initializable {
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
    private TextArea textd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     
        remindTimer();
        textd.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        textd.setStyle("-fx-text-alignment: center;-fx-text-fill: #eda1bd;");       
    }    

    @FXML
    private void rd1(MouseEvent event) {
        textd.setText("Veggie filled carbonara bake\n"+"\n"+
                "This veggie filled carbonara bake is the most delicious dinner ever! Kids and adults love it and it's packed full of veggies.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1 zucchini grated\n" +
" 300 grams wholemeal pasta cooked and drained\n" +
" 1 carrot grated\n" +
" 3 rashers bacon finely chopped\n" +
" 2 tbsps olive oil\n" +
" 2 cloves garlic crushed\n" +
" 4 eggs\n" +
" 300 ml cream\n" +
" ½ cup parmesan grated\n" +
" 2 cups cheddar cheese grated\n"+"\n"+
                "----------Instructions----------\n"+
"1-In a frypan over medium heat fry the bacon in the olive oil until golden.\n" +
"2-Add the garlic and cook a minute longer.\n" +
"3-Add the bacon and garlic to the cooked pasta with all the veg and stir in a large baking dish.\n" +
"4-In a jug whisk the eggs with the cream. Add the parmesan and 1 cup of the cheddar.\n" +
"5-Stir this through the pasta.\n" +
"6-(IF YOU'RE PREPARING EARLY IN THE DAY:stop here and refrigerate).\n" +
"7-Top the lot with the extra cheddar.\n" +
"8-Cover with foil.\n" +
"9-Put it in a preheated oven (200 degrees) for ten minutes.\n" +
"10-Remove the foil and bake 10 minutes more or until golden."

                );        
    }
    @FXML
    private void rd2(MouseEvent event) {
        textd.setText("Sticky Chicken Wings\n"+"\n"+
                "Sticky Chicken Wings, deliciously sticky, fall apart wings, made in the slow cooker, Instant Pot, pressure cooker or dutch oven! This is your next family favourite dinner.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1.5 kgs of chicken wings chopped into three pieces (you could easily use drumettes only)\n" +
" 2 cups honey\n" +
" ¾ cup soy sauce\n" +
" ¾ cup sweet chilli sauce\n" +
" 1 clove garlic minced\n" +
" 2 cm ginger grated\n" +
" A bunch of coriander leaves chopped\n" +
" 2 spring onions sliced\n"+"\n"+
                "----------Instructions----------\n"+
"1-In a medium frypan, fry the chicken wings in batches until golden (I have skipped this step before but it really adds to the flavour so I recommend it)\n" +
"2-Mix the honey, soy sauce, sweet chilli sauce, garlic, ginger together in a jug.\n" +
"--Slow Cooker--\n" +
"Place the browned chicken in the slow cooker and pour over the sauce, coating all the chicken. Cook for 5 hours on low, 2.5 hours on high.\n" +
"--Instant Pot--\n" +
"Pour the sauce over the chicken wings,coating all the chicken. Cook for 20 minutes, high pressure, manual pressure release at the end.\n" +
"--Dutch Oven--\n" +
"Place the chicken in the dutch oven and pour the sauce over the chicken wings, coating all the chicken. Cook for 2 hours at 160 with the lid on.\n" +
"--Serving--\n" +
"Place rice on a large platter.\n" +
"Place steamed veggies on the platter.\n" +
"Top with the chicken, spring onions and coriander.\n" +
"Pour over extra sauce"

                );        
    }
    @FXML
    private void rd3(MouseEvent event) {
        textd.setText("Chicken Taco Rice\n"+"\n"+
                "Spice up taco night by having this yummy chicken taco rice instead! This Mexican chicken and rice is filled with veggies and packed with flavour!\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1 kg chicken breasts (approx 4 breasts) sliced 1cms thick\n" +
" 3 tbsps olive oil\n" +
" 2 cups brown rice (uncooked) makes about 3.5 cups when cooked- cook it in your rice cooker, or on the stove or your preferred method\n" +
" 1 carrot grated\n" +
" 1 zucchini grated\n" +
" 1 cup frozen corn kernels\n" +
" 1 cup frozen pea kernels\n" +
" 1 onion diced (I used a red onion)\n" +
" ½ cup fresh coriander leaves only, chopped roughly.\n" +
" juice of one lime\n" +
"--Spice Mix--\n" +
" ½ tsp cumin ground\n" +
" ½ tsp chilli powder\n" +
" ½ tsp oregano dried\n" +
" ½ tsp paprika\n" +
" ½ tsp pepper\n" +
" ½ tsp salt\n"+"\n"+
                "----------Instructions----------\n"+
"1-Get your rice cooking! I do this in the rice cooker and it finishes just when I get to the point where I need to add it to the recipe. 2 cups of uncooked brown rice needs 4 cups of water to cook.\n" +
"2-Grate the zucchini and carrot.\n" +
"3-Dice the onion.\n" +
"4-Slice the chicken\n" +
"5-Make your spice mix! Combine the spices in a bowl together and mix well.\n" +
"6-Heat the oil in the base of your frypan. Over medium/high heat.\n" +
"7-Fry off the chicken- you want it to be golden. Return the chicken to the pan.\n" +
"8-Add the zucchini, carrot and onion to the pan with the spice mix and stir well.\n" +
"9-Add the corn, and peas to the pan and the rice. Mix well.\n" +
"10-Return the chicken to the pan.\n" +
"11-Add ½ cup water and the juice of 1 lime.\n" +
"12-Cook until all the water has evaporated.\n" +
"13-Garnish with coriander and serve."

                );        
    }
    @FXML
    private void rd4(MouseEvent event) {
        textd.setText("Coconut Chicken Tenders\n"+"\n"+
                "Baked or airfried, these Coconut Chicken Tenders are an awesome way to up your chicken nugget game! Gluten and dairy free.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 1.5 kgs chicken breast\n" +
" 400 mls coconut milk\n" +
" 1.5 cups coconut flour\n" +
" 2 cups of breadcrumbs of your choice (I've used gluten free \"panko\")\n" +
" 1 cup shredded coconut\n" +
" 6 tablespoons quinoa flakes\n" +
" 2 eggs\n" +
" 1 cup water\n"+"\n"+
                "----------Instructions----------\n"+
"1-Decide how you want your chicken shaped, cut out any excess fat and chop up.\n" +
"2-Pour the coconut milk over the chopped chicken and leave in the fridge for at least an hour.\n" +
"3-Drain the coconut milk from the chicken pieces and discard.\n" +
"4-Roll the chicken in the coconut flour.\n" +
"5-Whisk the eggs with a cup of water.\n" +
"6-Mix the remaining dry ingredients together.\n" +
"7-Dip the chicken strips in the egg and then dip into the dry ingredients. Lay out on a tray.\n" +
"8-BAKE at 180 OR FREEZE.\n" +
"9-Lightly grease an oven tray with the oil of your choice and drizzle the oil over the chicken.\n" +
"10-Bake at 180 degrees for approx 30 minutes, turning halfway through"

                );        
    }
    @FXML
    private void rd5(MouseEvent event) {
        textd.setText("Mango Chicken Curry\n"+"\n"+
                "Mango chicken curry, the perfect curry for winter weeknight meals! Stovetop, pressure cooker or slow cooker, everyone loves this dinner.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 3 mangoes flesh removed and roughly chopped\n" +
" 1 tablespoon peanut oil\n" +
" 1 kg boneless chicken thighs chopped into bite size chunks\n" +
" 1 onion thinly sliced\n" +
" 3 tbsp korma curry paste korma, or make your own]\n" +
" ½ head of cauliflower chopped into florets\n" +
" 2 carrots peeled and chopped into rounds\n" +
" 400 ml can coconut milk\n" +
" ½ cup 125ml chicken stock\n" +
" 1 cup frozen peas\n" +
" ½ bunch coriander leaves only for serving\n"+"\n"+
                "----------Instructions----------\n"+
"1-Place the mango into a blender blender and blitz until smooth.\n" +
"2-Heat half the oil in a large frypan and brown the chicken in batches.\n" +
"3-Remove the chicken and over medium heat, heat the rest of the oil.\n" +
"4-Add onion and cook for 2 mins, don't allow it to brown.\n" +
"5-Add curry paste and cook stirring for 2 mins.\n" +
"6-Add the carrots and cauliflower.\n" +
"7-Stir in coconut milk, stock and pureed mango.\n" +
"8-Return the chicken to the pan. Bring to the boil.\n" +
"9-Reduce heat to low and cook covered for 15 mins or until chicken is cooked through.\n" +
"10-Add the frozen peas and cook for 5 minutes more.\n" +
"11-Sprinkle with coriander leaves and serve."

                );        
    }
    @FXML
    private void rd6(MouseEvent event) {
        textd.setText("Creamy Mushroom Curry\n"+"\n"+
                "This delicious creamy mushroom curry is easy to prepare, vegetarian and filled with yummy flavours the whole family will love.\n"+"\n"+
                "----------Ingredients----------\n"+
                " 500 grams button mushrooms\n" +
" 60 grams butter (or ghee, swap for oil is making this curry vegan)\n" +
" 1 onion\n" +
" 2 zucchinis\n" +
" 400 mls coconut milk\n" +
" 700 grams passata\n" +
" 2 tsps garam masala\n" +
" ¾ tsp sweet paprika\n" +
" 1 tsp ground coriander\n" +
" 1 cinnamon stick\n" +
" 6 cardamon pods\n" +
" 1 tsp fresh ginger\n" +
" 2 tbsps lemon juice\n"+"\n"+
                "----------Instructions----------\n"+
"1-Chop the onions, zucchini, slice the mushrooms, finely chop the ginger.\n" +
"2-Add the butter to your pot and melt.\n" +
"3-Add the onion, ginger and all the spices and str quickly to coat in the spices.\n" +
"4-Add the zucchini and the mushroons and coat in the spices.\n" +
"5-Add the passata and mix well.\n" +
"6-Add the coconut milk and the lemon juice and mix well.\n" +
"7-Choose your method and cook!\n" +
"  Slow cooker: 8 hours on low, 4 hours on high.\n" +
"  Instant Pot: 35 minutes on high, manual pressure release.\n" +
"  Pressure cooker:45 minutes on high heat\n" +
"  Stove: 1 hour at a simmer (lid on)"

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
