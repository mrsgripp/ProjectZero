package org.example.Model;

public class Food {

    private String[] FoodCategories = {
            "Chicken"
            ,"Beef"
            ,"Pork"
            ,"Fish"
            ,"Eggs"
            ,"Liquids"
            ,"Popcorn"
    };

    private String Food;



    public void getFoodCategories(){

        for(int i =0; i < FoodCategories.length; i++){
            System.out.println(FoodCategories[i]);
        }
    }

    public void SetFoodSelection(String Food){

        this.Food = Food;
    }

    public String GetFoodSelection(){

        return Food;
    }
}
