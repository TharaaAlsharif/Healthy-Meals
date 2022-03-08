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
 * @author user
 */
@Entity
@Table(name="PLANNER")
public class MealPlanner  implements java.io.Serializable{
    @Id
    @Column(name="id")     
    private String id;    
    @Column(name="Sunday")     
    private String sunday;
    @Column(name="Monday") 
    private String monday;
    @Column(name="Tuesday") 
    private String tuesday;
    @Column(name="Wedneday") 
    private String wedneday;
    @Column(name="Thursday") 
    private String thursday;
    @Column(name="Friday") 
    private String friday;
    @Column(name="Saturday") 
    private String saturday;
    @Column(name="UserName")
    private String username;



    public MealPlanner() {
    }

    public MealPlanner(String id,String sunday, String monday, String tuesday, String wedneday, String thursday, String friday, String saturday) {
        this.id=id;
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wedneday = wedneday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWedneday() {
        return wedneday;
    }

    public void setWedneday(String wedneday) {
        this.wedneday = wedneday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
