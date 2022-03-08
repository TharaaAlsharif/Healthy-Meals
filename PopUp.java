/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author user
 */
public class PopUp {

    //private Button Popupbutton;

    private Label PopupTitlemsg;

    private Label PopupTimemsg;

    private Label PopupDatemsg;    
    
    
    public PopUp() {
    }

    public Label getPopupTitlemsg() {
        return PopupTitlemsg;
    }

    public Label getPopupTimemsg() {
        return PopupTimemsg;
    }

    public Label getPopupDatemsg() {
        return PopupDatemsg;
    }

    public void setPopupTitlemsg(Label PopupTitlemsg) {
        this.PopupTitlemsg = PopupTitlemsg;
    }

    public void setPopupTimemsg(Label PopupTimemsg) {
        this.PopupTimemsg = PopupTimemsg;
    }

    public void setPopupDatemsg(Label PopupDatemsg) {
        this.PopupDatemsg = PopupDatemsg;
    }
    
}
