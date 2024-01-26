package org.example.Service;
import org.example.Exception.FoodSelectionException;
import org.example.Exception.FishException;
import org.example.Main;

public class ReHeat {


    public String getSuggestedHeatingTime(String Food) throws FoodSelectionException, FishException {
        if (Food.equals("Fish")){

            Main.log.warn("Throwing Fish Exception due to reheating fish being against office policy");
            throw new FishException("Food Selection: Fish");
        }
        else if (Food.equals("Eggs")||Food.equals("Liquids")){

            return "The suggested heating time is 60 seconds.";
        }
        else if (Food.equals("Chicken")||Food.equals("Pork")||Food.equals("Beef")){
            return "The suggested heating time is 120 seconds.";
        }
        else if (Food.equals("Popcorn")){
            return "The suggested heating time is 150 seconds.";
        }
        else {
            Main.log.warn("Throwing Food Selection Exception: invalid food selection made");
            throw new FoodSelectionException("Invalid Food Category Selection");
        }

    };

    public int SuggestedSeconds(String Food){
        if (Food.equals("Eggs")||Food.equals("Liquid")){

            return 60;
        }
        else if (Food.equals("Chicken")||Food.equals("Pork")||Food.equals("Beef")){
            return 120;
        }
        else if (Food.equals("Popcorn")){
            return 150;
        }
        else return 0;
    }


}