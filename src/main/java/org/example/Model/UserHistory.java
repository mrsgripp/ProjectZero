package org.example.Model;
import java.sql.Timestamp;
public class UserHistory {

    private String username;
    private String foodselection;
    private int heatingtime;
    private Timestamp timeofuse;

    public UserHistory(String username, String foodselection, int heatingtime, Timestamp timeofuse){
        this.username = username;
        this.foodselection = foodselection;
        this.heatingtime = heatingtime;
        this.timeofuse = timeofuse;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setFoodselection(String foodselection){
        this.foodselection = foodselection;
    }

    public String getFoodselection(){
        return foodselection;
    }

    public void setHeatingtime(int heatingtime){
        this.heatingtime = heatingtime;
    }

    public int getHeatingTime(){
        return heatingtime;
    }
    public void setTimeofuse(Timestamp timeofuse){
        this.timeofuse = timeofuse;
    }

    public Timestamp getTimeofuse(){
        return timeofuse;
    }

    @Override
    public String toString() {
        return "\n" + "Username: " + username +
                "/ Food Selection: " + foodselection +
                "/ Heating Time in Seconds: " + heatingtime +
                "/ Timestamp of Microwave Use: " + timeofuse;
    }
}
