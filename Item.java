/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 96655
 */

@Entity
@Table(name="listitem")
public class Item implements java.io.Serializable {
    
    
    @Column(name="item")
    private String item;
    
    @Column(name="status")
    private String status;

    @Column(name="userN")
    private String username;
    
    @Id
    @GeneratedValue 
    @Column(name="ID")
    private int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public Item() {
       this.status="unchecked";
    }
    

    public Item(String item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
    
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    
}
