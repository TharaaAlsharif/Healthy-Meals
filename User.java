/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="signup")
public class User implements java.io.Serializable {
    
    public User() {
    }
     @Id
     @Column(name="UserName")
     private String UserName;
     
     @Column(name="FName")
     private String FName;
      
     @Column(name="LName") 
     private String LName; 
           
     @Column(name="ChildBirth")
     private String ChildBirth;
                
     @Column(name="ChildGender")
     private String ChildGender;
                     
     @Column(name="Password")
     private String Password;
     @Column(name="ID")
     private int ID=0;     

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
    }
    public String getChildBirth() {
        return ChildBirth;
    }
    public String getChildGender() {
        return ChildGender;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public void setChildBirth(String ChildBirth) {
        this.ChildBirth = ChildBirth;
    }

    public void setChildGender(String ChildGender) {
        this.ChildGender = ChildGender;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }



}