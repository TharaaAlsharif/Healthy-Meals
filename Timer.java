/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthymeals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name="REMINDER")
public class Timer implements java.io.Serializable{
    @Id
    @GeneratedValue
    @Column(name="ID")
    private String id; 
    
    @Column(name="Title")    
    private String title;
    
    @Column(name="Time")
    private String time;
    
    @Column(name="Date")
    private String date ;
   
    @Column(name="UserName")
    private String username;
    
    @Transient
    private LocalTime Time;
    @Transient
    private LocalDate Date ;    
    @Transient
    private TextField text = new TextField(); 
    @Transient
    private Timeline clock;
    @Transient
    private long days ;
    @Transient
    private long seconds ;
    @Transient
    private long minutes;
    @Transient
    private long hours ; // % 24 not needed 
    @Transient
            
    private static final int SECONDS_IN_A_DAY = 24 * 60 * 60;    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Timer(String title, LocalTime time, LocalDate date, TextField text) {
        this.title = title;
        this.Time = time;
        this.Date = date;
        this.text = text;
        this.text.setMaxWidth(130);
        this.text.setAlignment(Pos.CENTER);        
        this.time = time.format(DateTimeFormatter.ofPattern("hh:mm a"));
        this.date = date.toString();
        //this.username=username.getUserName();
    }

    public Timer() {
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public void settime(String time) {
        this.time = time;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.Time = time;
    }

    public void setDate(LocalDate date) {
        this.Date = date;
    }

    public void setText(TextField text) {
        this.text = text;
    }

    public void setClock(Timeline clock) {
        this.clock = clock;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public String getTitle() {
        return title;
    }
    public String gettime() {
        return time;
    }

    public String getdate() {
        return date;
    }
    public LocalTime getTime() {
        return Time;
    }

    public LocalDate getDate() {
        return Date;
    }

    public TextField getText() {
        return text;
    }

    public Timeline getClock() {
        return clock;
    }

    public long getDays() {
        return days;
    }

    public long getSeconds() {
        return seconds;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getHours() {
        return hours;
    }

    public static int getSECONDS_IN_A_DAY() {
        return SECONDS_IN_A_DAY;
    }


}
